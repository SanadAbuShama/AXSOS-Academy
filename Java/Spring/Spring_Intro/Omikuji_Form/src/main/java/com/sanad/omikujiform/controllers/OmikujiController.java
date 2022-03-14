package com.sanad.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiController {
	@GetMapping("/omikuji")
	public String home() {
		return "omikujiform.jsp";
	}

	@GetMapping("/omikuji/show")
	public String show(Model model, HttpSession session) {

		model.addAttribute("years", session.getAttribute("years"));
		model.addAttribute("city", session.getAttribute("city"));
		model.addAttribute("person", session.getAttribute("person"));
		model.addAttribute("hobby", session.getAttribute("hobby"));
		model.addAttribute("living", session.getAttribute("living"));
		model.addAttribute("nice", session.getAttribute("nice"));
		return "omikujishow.jsp";
	}

	@PostMapping("/submit")
	public String submit(HttpSession session, @RequestParam(value = "number") Integer years,
			@RequestParam(value = "city") String city, @RequestParam(value = "person") String person,
			@RequestParam(value = "hobby") String hobby, @RequestParam(value = "living") String living,
			@RequestParam(value = "nice") String nice) {
		session.setAttribute("years", years);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("living", living);
		session.setAttribute("nice", nice);
		return "redirect:/omikuji/show";
	}
}
