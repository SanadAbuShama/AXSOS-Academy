package com.sanad.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sanad.dojosandninjas.models.Dojo;
import com.sanad.dojosandninjas.models.Ninja;
import com.sanad.dojosandninjas.services.DojoService;
import com.sanad.dojosandninjas.services.NinjaService;

@Controller
public class MainController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;

	public MainController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}

	// Dojos routes

	@GetMapping("/")
	public String landing() {

		return "redirect:/dojos";
	}

	@GetMapping("/dojos")
	public String dashboard(Model model) {

		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);

		return "/dojos/dashboard.jsp";
	}

	@GetMapping("/dojos/new")
	public String index(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojos/newDojo.jsp";
	}

	@PostMapping("/dojos")
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "/dojos/newDojo.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos";
		}
	}

	@GetMapping("/dojos/{id}")
	public String index(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "/dojos/dojoDetails.jsp";
	}

	// Ninjas routes

	@GetMapping("/ninjas/new")
	public String newNinja(Model model, @ModelAttribute("ninja") Ninja ninja) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "/ninjas/newNinja.jsp";
	}

	@PostMapping("/ninjas")
	public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			return "/ninjas/newNinja.jsp";
		} else {
			ninjaService.createNinja(ninja);
			return "redirect:/dojos";
		}
	}

//
}
