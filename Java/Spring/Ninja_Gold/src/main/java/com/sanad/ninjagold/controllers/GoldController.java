package com.sanad.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoldController {

	@GetMapping("/")
	public String home(HttpSession session, Model model) {
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}

		int gold = (int) session.getAttribute("gold");
		String messages = (String) session.getAttribute("messages");
		model.addAttribute("gold", gold);
		model.addAttribute("messages", messages);
		if (gold < -20) {
			return "redirect:/prison";
		} else {
			return "index.jsp";
		}

	}

	@GetMapping("/prison")
	public String prison() {
		return "prison.jsp";

	}

	@PostMapping("/get_gold")
	public String getGold(HttpSession session, @RequestParam(value = "place") String place) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd YYYY K:mm a");
		int gold = (int) session.getAttribute("gold");
		if (place.equals("farm") || place.equals("cave") || place.equals("house")) {
			int earning;
			if (place.equals("farm")) {
				earning = (int) Math.floor(Math.random() * 11) + 10;
			} else if (place.equals("cave")) {
				earning = (int) Math.floor(Math.random() * 6) + 5;
			} else {
				earning = (int) Math.floor(Math.random() * 4) + 2;
			}
			session.setAttribute("gold", gold += earning);
			if (session.getAttribute("messages") == null) {
				session.setAttribute("messages",
						String.format("<p class='text-success'>You have entered the %s and earned %d golds (%s)</p>",
								place, earning, sdf.format(new Date())));

			} else {
				String messages = (String) session.getAttribute("messages");
				messages = String.format("<p class='text-success'>You have entered the %s and earned %d golds (%s)</p>",
						place, earning, sdf.format(new Date())) + messages;
				session.setAttribute("messages", messages);
			}
		}

		else if (place.equals("spa")) {
			int change = (int) Math.floor(Math.random() * 16) + 5;
			session.setAttribute("gold", gold -= change);
			if (session.getAttribute("messages") == null) {
				session.setAttribute("messages",
						String.format("<p class='text-danger'>You have gone on a %s and lost %d golds (%s)</p>", place,
								change, sdf.format(new Date())));

			} else {
				String messages = (String) session.getAttribute("messages");
				messages = String.format("<p class='text-danger'>You have gone on a %s and lost %d golds (%s)</p>",
						place, change, sdf.format(new Date())) + messages;
				session.setAttribute("messages", messages);
			}
		}

		else {
			int change = (int) Math.floor(Math.random() * 51);
			int rand = (int) Math.floor(Math.random() * 2);
			if (rand == 0) {
				session.setAttribute("gold", gold -= change);
				if (session.getAttribute("messages") == null) {
					session.setAttribute("messages",
							String.format("<p class='text-danger'>You have gone on a %s and lost %d golds (%s)</p>",
									place, change, sdf.format(new Date())));

				} else {
					String messages = (String) session.getAttribute("messages");
					messages = String.format("<p class='text-danger'>You have gone on a %s and lost %d golds (%s)</p>",
							place, change, sdf.format(new Date())) + messages;
					session.setAttribute("messages", messages);
				}
			} else {
				session.setAttribute("gold", gold += change);
				if (session.getAttribute("messages") == null) {
					session.setAttribute("messages",
							String.format("<p class='text-success'>You have gone on a %s and earned %d golds (%s)</p>",
									place, change, sdf.format(new Date())));

				} else {
					String messages = (String) session.getAttribute("messages");
					messages = String.format(
							"<p class='text-success'>You have gone on a %s and earned %d golds (%s)</p>", place, change,
							sdf.format(new Date())) + messages;
					session.setAttribute("messages", messages);
				}
			}
		}

		return "redirect:/";
	}

	@GetMapping("/destroy")
	public String destroy(HttpSession session) {
		session.setAttribute("gold", 0);
		session.setAttribute("messages", "");
		return "redirect:/";
	}
}
