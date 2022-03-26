package com.sanad.events.controllers;

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

import com.sanad.events.models.Comment;
import com.sanad.events.models.EventM;
import com.sanad.events.models.User;
import com.sanad.events.services.CommentService;
import com.sanad.events.services.EventService;
import com.sanad.events.services.UserService;

//.. don't forget to inlcude all your imports! ..

@Controller
public class MainController {

	@Autowired
	private EventService eventServ;

	@Autowired
	private UserService userServ;

	@Autowired
	private CommentService commentServ;

	@GetMapping("/events")
	public String events(Model model, HttpSession session, @ModelAttribute("newEvent") EventM newEvent) {
		if (session.getAttribute("userId") != null) {
			Long userId = (long) session.getAttribute("userId");
			User loggedUser = userServ.findUserById(userId);
			List<EventM> eventsInState = eventServ.eventsInState(loggedUser.getState());
			List<EventM> eventsNotInState = eventServ.eventsInOtherStates(loggedUser.getState());
			model.addAttribute("eventsInState", eventsInState);
			model.addAttribute("eventsNotInState", eventsNotInState);
			model.addAttribute("loggedUser", loggedUser);
			return "/events/events.jsp";
		} else {
			return "redirect:/home";
		}

	}

	@PostMapping("/events")
	public String addEvent(Model model, HttpSession session, @Valid @ModelAttribute("newEvent") EventM newEvent,
			BindingResult result) {
		if (session.getAttribute("userId") != null) {
			Long userId = (long) session.getAttribute("userId");
			User loggedUser = userServ.findUserById(userId);
			if (result.hasErrors()) {
				List<EventM> eventsInState = eventServ.eventsInState(loggedUser.getState());
				List<EventM> eventsNotInState = eventServ.eventsInOtherStates(loggedUser.getState());
				model.addAttribute("eventsInState", eventsInState);
				model.addAttribute("eventsNotInState", eventsNotInState);
				model.addAttribute("loggedUser", loggedUser);
				return "/events/events.jsp";
			} else {
				eventServ.createEvent(newEvent, loggedUser);
				return "redirect:/events";
			}

		} else {
			return "redirect:/home";
		}

	}

	@PutMapping("/events/{id}/join")
	public String addEvent(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			eventServ.joinEvent(id, (long) session.getAttribute("userId"));
			return "redirect:/events";

		} else {
			return "redirect:/home";
		}

	}

	@PutMapping("/events/{id}/cancel")
	public String cancelEvent(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			eventServ.cancelEvent(id, (long) session.getAttribute("userId"));
			return "redirect:/events";

		} else {
			return "redirect:/home";
		}

	}

	@DeleteMapping("/events/{id}")
	public String deleteEvent(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			eventServ.deleteEvent(id);
			return "redirect:/events";
		} else {
			return "redirect:/home";
		}

	}

	@GetMapping("/events/{id}")
	public String eventDetails(@PathVariable("id") Long id, Model model, HttpSession session,
			@ModelAttribute("newComment") Comment newComment) {
		if (session.getAttribute("userId") != null) {
			EventM event = eventServ.findEventById(id);
			model.addAttribute("event", event);
			return "/events/eventDetails.jsp";
		} else {
			return "redirect:/home";
		}

	}

	@PostMapping("/events/{id}")
	public String addComment(@PathVariable("id") Long id, Model model, HttpSession session,
			@Valid @ModelAttribute("newComment") Comment newComment, BindingResult result) {
		if (session.getAttribute("userId") != null) {
			if (result.hasErrors()) {
				EventM event = eventServ.findEventById(id);
				model.addAttribute("event", event);
				return "/events/eventDetails.jsp";
			} else {
				commentServ.addComment(id, (long) session.getAttribute("userId"), newComment);
				return String.format("redirect:/events/%d", id);
			}

		} else {
			return "redirect:/home";
		}

	}

	@GetMapping("/events/{id}/edit")
	public String editEvent(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			EventM foundEvent = eventServ.findEventById(id);
			model.addAttribute("event", foundEvent);
			return "/events/editEvent.jsp";
		} else {
			return "redirect:/home";
		}

	}

	@PutMapping("/events/{id}")
	public String updateEvent(@PathVariable("id") Long id, @Valid @ModelAttribute("event") EventM event,
			BindingResult result, Model model, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			if (result.hasErrors()) {
				return "/events/editEvent.jsp";
			} else {
				eventServ.updateEvent(id, event);
				return "redirect:/events";
			}

		} else {
			return "redirect:/home";
		}

	}

}
