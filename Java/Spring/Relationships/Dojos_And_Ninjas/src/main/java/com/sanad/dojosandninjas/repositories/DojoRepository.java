package com.sanad.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sanad.dojosandninjas.models.Dojo;

//...
//...
@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {
	// this method retrieves all the books from the database
	List<Dojo> findAll();

	// this method finds books with descriptions containing the search string
//	List<Language> findByDescriptionContaining(String search);

}
