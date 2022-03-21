package com.sanad.authentication.controllers;

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

import com.sanad.authentication.models.LoginUser;
import com.sanad.authentication.models.User;
import com.sanad.authentication.services.UserService;

//.. don't forget to inlcude all your imports! ..

@Controller
public class HomeController {

	@Autowired
	private UserService userServ;

	@GetMapping("/")
	public String index(Model model) {

		return "redirect:/home";
	}

	@GetMapping("/home")
	public String home(Model model) {

		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "login_registration.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {

		User registeredUser = userServ.register(newUser, result);

		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "login_registration.jsp";
		}

		session.setAttribute("userId", registeredUser.getId());
		return "redirect:/success";
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {

		User user = userServ.login(newLogin, result);

		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "login_registration.jsp";
		}

		session.setAttribute("userId", user.getId());

		return "redirect:/success";

	}

	@GetMapping("/success")
	public String success(Model model, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			User loggedUser = userServ.findUserById((long) session.getAttribute("userId"));
			model.addAttribute("loggedUser", loggedUser);
			return "success.jsp";
		}
		return "redirect:/home";
	}

	@GetMapping("/logout")
	public String logout(Model model, HttpSession session) {
		session.invalidate();
		return "redirect:/home";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		userServ.deleteUser(id);
		return "redirect:/home";
	}

}
