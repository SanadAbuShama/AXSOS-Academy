package com.sanad.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sanad.productsandcategories.models.Category;
import com.sanad.productsandcategories.models.Product;

//...
//...
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	// this method retrieves all the books from the database
	List<Product> findAll();

	List<Product> findByCategoriesNotContains(Category category);
	// this method finds books with descriptions containing the search string
//	List<Language> findByDescriptionContaining(String search);

}
