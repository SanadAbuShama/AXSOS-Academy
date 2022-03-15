package com.sanad.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sanad.mvc.models.Expense;

//...
//...
@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {
	// this method retrieves all the books from the database
	List<Expense> findAll();

	// this method finds books with descriptions containing the search string
	List<Expense> findByDescriptionContaining(String search);

}
