package com.sanad.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.sanad.bookclub.models.Book;
import com.sanad.bookclub.models.User;
import com.sanad.bookclub.services.BookService;
import com.sanad.bookclub.services.UserService;

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
