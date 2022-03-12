package com.sanad.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {

	@RequestMapping("/")
	public String home(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		} else {
			Integer count = (Integer) session.getAttribute("count");
			session.setAttribute("count", count + 1);
		}
		return "home.jsp";
	}

	@RequestMapping("/counter")
	public String server(HttpSession session, Model model) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		model.addAttribute("count", session.getAttribute("count"));
		return "counter.jsp";
	}

	@RequestMapping("/counter_by_2")
	public String counter_by_2(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		} else {
			Integer count = (Integer) session.getAttribute("count");
			session.setAttribute("count", count + 2);
		}
		return "counter_by_2.jsp";
	}

	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("count", 0);
		return "reset.jsp";
	}

}
