package com.sanad.bookbroker.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.sanad.bookbroker.models.Book;
import com.sanad.bookbroker.models.User;
import com.sanad.bookbroker.services.BookService;
import com.sanad.bookbroker.services.UserService;

@Controller
public class BookController {

	@Autowired
	private BookService bookServ;
	@Autowired
	private UserService userServ;

	@GetMapping("/books")
	public String home(Model model, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			User loggedUser = userServ.findUserById((long) session.getAttribute("userId"));
			List<Book> books = bookServ.allBooks();
			model.addAttribute("books", books);
			model.addAttribute("loggedUser", loggedUser);
			return "/users/dashboard.jsp";
		}

		return "redirect:/home";
	}

	@GetMapping("/bookmarket")
	public String bookmarket(Model model, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			User loggedUser = userServ.findUserById((long) session.getAttribute("userId"));
			List<Book> availableBooks = bookServ.availableBooks();
			List<Book> borrowdBooksByLoggedUser = bookServ.borrowedBooks((long) session.getAttribute("userId"));
			model.addAttribute("availabeBooks", availableBooks);
			model.addAttribute("borrowedBooks", borrowdBooksByLoggedUser);
			model.addAttribute("loggedUser", loggedUser);
			return "/books/bookmarket.jsp";
		}

		return "redirect:/home";
	}

	@PostMapping("/books/{id}")
	public String borrow(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("userId") != null) {

			bookServ.borrowBook(id, (long) session.getAttribute("userId"));

			return "redirect:/bookmarket";

		} else {
			return "redirect:/home";
		}

	}

	@PutMapping("/books/{id}/return")
	public String returnBook(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("userId") != null) {

			bookServ.returnBorrowedBook(id);

			return "redirect:/bookmarket";

		} else {
			return "redirect:/home";
		}

	}

	@DeleteMapping("/books/{id}")
	public String delete(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("userId") != null) {

			bookServ.deleteBook(id);
			return "redirect:/bookmarket";

		} else {
			return "redirect:/home";
		}

	}

	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("newBook") Book newBook, HttpSession session) {
		if (session.getAttribute("userId") != null) {

			return "/books/newBook.jsp";
		}

		return "redirect:/home";
	}

	@PostMapping("/books")
	public String register(@Valid @ModelAttribute("newBook") Book newBook, BindingResult result, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			if (result.hasErrors()) {

				return "/books/newBook.jsp";
			} else {

				bookServ.createBook(newBook, (long) session.getAttribute("userId"));

				return "redirect:/books";
			}
		} else {
			return "redirect:/home";
		}

	}

	@GetMapping("/books/{id}")
	public String home(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("userId") != null) {

			Book book = bookServ.findBookById(id);
			model.addAttribute("book", book);
			model.addAttribute("loggedUserId", session.getAttribute("userId"));
			return "/books/bookDetails.jsp";
		}

		return "redirect:/home";
	}

	@GetMapping("/books/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			Book book = bookServ.findBookById(id);
			model.addAttribute("book", book);
			return "/books/editBook.jsp";
		}

		return "redirect:/home";
	}

	@PutMapping("/books/{id}")
	public String editBook(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result,
			HttpSession session) {
		if (session.getAttribute("userId") != null) {
			if (result.hasErrors()) {

				return "/books/editBook.jsp";
			} else {
				bookServ.updateBook(book, id);
				return "redirect:/books";
			}
		} else {
			return "redirect:/home";
		}

	}

}
