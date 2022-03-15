package com.sanad.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.sanad.savetravels.models.Expense;
import com.sanad.savetravels.services.ExpenseService;

@Controller
public class ExpensesController {
	private final ExpenseService expenseService;

	public ExpensesController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}

	@GetMapping("/expenses")
	public String index(Model model, @ModelAttribute("expense") Expense expense) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
		return "/expenses/index.jsp";
	}

	@PostMapping("/expenses")
	public String create(Model model, @Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if (result.hasErrors()) {
			List<Expense> expenses = expenseService.allExpenses();
			model.addAttribute("expenses", expenses);
			return "/expenses/index.jsp";
		} else {
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
	}

	@GetMapping("/expenses/{id}")
	public String index(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "/expenses/expenseDetails.jsp";
	}

	@GetMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Expense exp = expenseService.findExpense(id);
		model.addAttribute("expense", exp);
		return "/expenses/edit.jsp";
	}

	@PutMapping("/expenses/edit/{id}")
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("expense") Expense expense,
			BindingResult result) {
		if (result.hasErrors()) {
			return "/expenses/edit.jsp";
		} else {
			expenseService.updateExpense(id, expense);
			return "redirect:/expenses";
		}

	}

	@DeleteMapping("/expenses/{id}")
	public String destroy(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/expenses";
	}

//
}
