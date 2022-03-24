package com.sanad.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sanad.dojooverflow.models.Question;

//...
//...
@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
	// this method retrieves all the books from the database
	List<Question> findAllByOrderByCreatedAtDesc();

//	List<Question> findByProductsNotContains(Question question);
	// this method finds books with descriptions containing the search string
//	List<Language> findByDescriptionContaining(String search);

}
