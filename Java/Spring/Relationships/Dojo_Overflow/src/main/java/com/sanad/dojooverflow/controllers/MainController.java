package com.sanad.dojooverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sanad.dojooverflow.models.Answer;
import com.sanad.dojooverflow.models.Question;
import com.sanad.dojooverflow.services.MainService;

@Controller
public class MainController {

	@Autowired
	private MainService mainServ;

	// Categories routes

	@GetMapping("/")
	public String landing() {

		return "redirect:/questions";
	}

	@GetMapping("/questions")
	public String questions(Model model) {

		List<Question> questions = mainServ.allQuestions();
		model.addAttribute("questions", questions);

		return "questions.jsp";
	}

	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("newQuestion") Question newQuestion) {

		return "newQuestion.jsp";
	}

	@PostMapping("/questions")
	public String create(@RequestParam(value = "questionTags") String tags,
			@Valid @ModelAttribute("newQuestion") Question newQuestion, BindingResult result) {

		mainServ.createQuestion(tags, newQuestion, result);

		if (result.hasErrors()) {

			return "newQuestion.jsp";
		} else {

			return "redirect:/questions";
		}

	}

	@GetMapping("/questions/{id}")
	public String questionDetails(@PathVariable("id") Long id, @ModelAttribute("newAnswer") Answer newAnswer,
			Model model) {

		Question question = mainServ.findQuestionById(id);
		model.addAttribute("question", question);
		return "questionDetails.jsp";
	}

	@PostMapping("/questions/{id}")
	public String newAnswer(@PathVariable("id") Long id, @Valid @ModelAttribute("newAnswer") Answer newAnswer,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			Question question = mainServ.findQuestionById(id);
			model.addAttribute("question", question);
			return "questionDetails.jsp";
		} else {
			mainServ.addAnswer(id, newAnswer);
			return String.format("redirect:/questions/%d", id);
		}

	}

}
