package com.sanad.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sanad.productsandcategories.models.Category;
import com.sanad.productsandcategories.models.Product;
import com.sanad.productsandcategories.repositories.CategoryRepository;
import com.sanad.productsandcategories.repositories.ProductRepository;

@Service
public class CategoryService {
	// adding the book repository as a dependency
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;

	public CategoryService(CategoryRepository categoryRepository, ProductRepository productRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
	}

	// returns all the categories
	public List<Category> allCategories() {
		return categoryRepository.findAll();
	}

	// creates a category
	public Category createCategory(Category b) {
		return categoryRepository.save(b);
	}

	// updates a category
	public Category addProductToCategory(long id, long productId) {
		Optional<Category> c = categoryRepository.findById(id);
		Optional<Product> p = productRepository.findById(productId);
		if (c.isPresent() && p.isPresent()) {
			Category category = c.get();
			Product product = p.get();
			category.getProducts().add(product);
			return categoryRepository.save(category);
		} else {
			return null;
		}

	}

	// retrieves a category
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}

	public List<Category> findCategoriesNotInProduct(Product product) {
		return categoryRepository.findByProductsNotContains(product);
	}

}
