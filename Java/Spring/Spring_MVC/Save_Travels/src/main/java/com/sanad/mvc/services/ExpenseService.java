package com.sanad.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

//...

import com.sanad.mvc.models.Expense;
import com.sanad.mvc.repositories.ExpenseRepository;

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

	// creates a book
	public Expense createExpense(Expense b) {
		return expenseRepository.save(b);
	}

//	// updates a book
//	public Expense updateExpense(long id, String title, String desc, String lang, Integer numOfPages) {
//		Optional<Expense> b = expenseRepository.findById(id);
//		if (b.isPresent()) {
//			Expense book = b.get();
//
//			return expenseRepository.save(book);
//		} else {
//			return null;
//		}
//
//	}

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
