package com.sanad.projectmanager.controllers;

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

import com.sanad.projectmanager.models.Project;
import com.sanad.projectmanager.models.Task;
import com.sanad.projectmanager.models.User;
import com.sanad.projectmanager.services.ProjectService;
import com.sanad.projectmanager.services.TaskService;
import com.sanad.projectmanager.services.UserService;

//.. don't forget to inlcude all your imports! ..

@Controller
public class ProjectController {

	@Autowired
	private ProjectService projServ;

	@Autowired
	private UserService userServ;

	@Autowired
	private TaskService taskServ;

	@GetMapping("/dashboard")
	public String index(Model model, HttpSession session) {
		if (session.getAttribute("userId") != null) {

			List<Project> projectsNotPartOf = projServ.projectsNotPartOf((long) session.getAttribute("userId"));
			User loggedUser = userServ.findUserById((long) session.getAttribute("userId"));
			model.addAttribute("projectsNotPartOf", projectsNotPartOf);
			model.addAttribute("loggedUser", loggedUser);
			return "/projects/dashboard.jsp";
		} else {
			return "redirect:/home";
		}

	}

	@GetMapping("/projects/{id}")
	public String index(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			User loggedUser = userServ.findUserById((long) session.getAttribute("userId"));
			Project project = projServ.findProjectById(id);
			model.addAttribute("project", project);
			model.addAttribute("loggedUser", loggedUser);
			return "/projects/projectDetails.jsp";
		} else {
			return "redirect:/home";
		}

	}

	@GetMapping("/projects/{id}/tasks")
	public String tasks(@PathVariable("id") Long id, @ModelAttribute("newTask") Task newTask, Model model,
			HttpSession session) {
		if (session.getAttribute("userId") != null) {
			Project project = projServ.findProjectById(id);
			model.addAttribute("project", project);

			return "/projects/projectTasks.jsp";
		} else {
			return "redirect:/home";
		}

	}

	@PostMapping("/projects/{id}/tasks")
	public String addTask(@PathVariable("id") Long id, @Valid @ModelAttribute("newTask") Task newTask,
			BindingResult result, Model model, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			if (result.hasErrors()) {
				Project project = projServ.findProjectById(id);
				model.addAttribute("project", project);
				return "/projects/projectTasks.jsp";
			} else {
				taskServ.createTask(newTask, id, (long) session.getAttribute("userId"));
				return String.format("redirect:/projects/%d/tasks", id);
			}

		} else {
			return "redirect:/home";
		}

	}

	@GetMapping("/projects/new")
	public String renderNewForm(@ModelAttribute("newProject") Project newProject, HttpSession session) {
		if (session.getAttribute("userId") != null) {

			return "/projects/newProject.jsp";
		} else {
			return "redirect:/home";
		}

	}

	@PostMapping("/projects")
	public String newProject(@Valid @ModelAttribute("newProject") Project newProject, BindingResult result,
			HttpSession session) {
		if (session.getAttribute("userId") != null) {
			if (result.hasErrors()) {
				return "/projects/newProject.jsp";
			} else {
				System.out.println(newProject.getId());
				projServ.createProject((long) session.getAttribute("userId"), newProject);
				return "redirect:/dashboard";
			}

		} else {
			return "redirect:/home";
		}

	}

	@GetMapping("/projects/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			Project project = projServ.findProjectById(id);
			model.addAttribute("project", project);
			return "/projects/editProject.jsp";
		}

		return "redirect:/home";
	}

	@PutMapping("/projects/{id}")
	public String editBook(@PathVariable("id") Long id, @Valid @ModelAttribute("project") Project project,
			BindingResult result, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			if (result.hasErrors()) {

				return "/projects/editProject.jsp";
			} else {
				projServ.updateProject(id, project);
				return "redirect:/dashboard";
			}
		} else {
			return "redirect:/home";
		}

	}

	@PutMapping("/projects/{id}/join")
	public String joinProject(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			projServ.joinProject(id, (long) session.getAttribute("userId"));
			return "redirect:/dashboard";
		} else {
			return "redirect:/home";
		}

	}

	@PutMapping("/projects/{id}/leave")
	public String leaveProject(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			projServ.leaveProject(id, (long) session.getAttribute("userId"));
			return "redirect:/dashboard";
		} else {
			return "redirect:/home";
		}

	}

	@DeleteMapping("/projects/{id}")
	public String deleteProject(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			projServ.deleteProject(id);
			return "redirect:/dashboard";
		} else {
			return "redirect:/home";
		}

	}

}
