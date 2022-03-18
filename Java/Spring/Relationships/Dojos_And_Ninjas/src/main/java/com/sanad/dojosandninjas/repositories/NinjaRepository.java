package com.sanad.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sanad.dojosandninjas.models.Ninja;

//...
//...
@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	// this method retrieves all the books from the database
	List<Ninja> findAll();

	// this method finds books with descriptions containing the search string
//	List<Language> findByDescriptionContaining(String search);

}
