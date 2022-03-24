package com.sanad.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sanad.dojooverflow.models.Answer;

//...
//...
@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
	// this method retrieves all the books from the database
	List<Answer> findAll();

//	List<Answer> findByCategoriesNotContains(Answer answer);
	// this method finds books with descriptions containing the search string
//	List<Language> findByDescriptionContaining(String search);

}
