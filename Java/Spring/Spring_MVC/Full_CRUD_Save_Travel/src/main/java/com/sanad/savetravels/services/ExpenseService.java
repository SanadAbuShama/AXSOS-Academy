package com.sanad.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sanad.savetravels.models.Expense;
import com.sanad.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	// adding the book repository as a dependency
	private final ExpenseRepository expenseRepository;

	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}

	// returns all the books
	public List<Expense> allExpenses() {
		return expenseRepository.findAll();
	}

	// creates an expense
	public Expense createExpense(Expense b) {
		return expenseRepository.save(b);
	}

	// updates an expense
	public Expense updateExpense(long id, Expense updatedExpense) {
		Optional<Expense> e = expenseRepository.findById(id);
		if (e.isPresent()) {
			Expense expense = e.get();
			expense.setName(updatedExpense.getName());
			expense.setVendor(updatedExpense.getVendor());
			expense.setAmount(updatedExpense.getAmount());
			expense.setDescription(updatedExpense.getDescription());
			return expenseRepository.save(expense);
		} else {
			return null;
		}

	}

	public void deleteExpense(Long id) {
		Expense expense = this.findExpense(id);

		expenseRepository.delete(expense);

	}

	// retrieves an expense
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if (optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}
}
