package com.sanad.dojooverflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sanad.dojooverflow.models.Tag;

//...
//...
@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
	// this method retrieves all the books from the database
	List<Tag> findAll();

	Optional<Tag> findBySubject(String subject);

//	List<Tag> findByCategoriesNotContains(Answer answer);
	// this method finds books with descriptions containing the search string
//	List<Language> findByDescriptionContaining(String search);

}
