package com.sanad.bookbroker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanad.bookbroker.models.Book;
import com.sanad.bookbroker.models.User;
import com.sanad.bookbroker.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;

	@Autowired
	private UserService userServ;

	public List<Book> allBooks() {
		return bookRepo.findAll();
	}

	public Book findBookById(Long id) {
		Optional<Book> b = bookRepo.findById(id);
		if (b.isPresent()) {
			Book book = b.get();
			return book;
		} else {
			return null;
		}
	}

	public void createBook(Book b, Long loggedUserId) {
		User loggedUser = userServ.findUserById(loggedUserId);
		b.setUser(loggedUser);
		bookRepo.save(b);
	}

	public void updateBook(Book updatedBook, Long bookId) {

		Book book = this.findBookById(bookId);
		book.setTitle(updatedBook.getTitle());
		book.setAuthor(updatedBook.getAuthor());
		book.setThoughts(updatedBook.getThoughts());
		bookRepo.save(book);
	}

	public List<Book> availableBooks() {
		return bookRepo.findByBorrowerNull();
	}

	public List<Book> borrowedBooks(Long borrowerId) {
		User borrower = userServ.findUserById(borrowerId);
		return bookRepo.findByBorrower(borrower);
	}

	public void borrowBook(Long bookId, Long borrowerId) {

		User borrower = userServ.findUserById(borrowerId);
		Book book = this.findBookById(bookId);

		book.setBorrower(borrower);
		bookRepo.save(book);

	}

	public void returnBorrowedBook(Long bookId) {

		Book book = this.findBookById(bookId);
		book.setBorrower(null);
		bookRepo.save(book);

	}

	public void deleteBook(Long bookId) {

		Book book = this.findBookById(bookId);
		bookRepo.delete(book);

	}

}
