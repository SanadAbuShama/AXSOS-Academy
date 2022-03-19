package com.sanad.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sanad.productsandcategories.models.Category;
import com.sanad.productsandcategories.models.Product;
import com.sanad.productsandcategories.repositories.CategoryRepository;
import com.sanad.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	// adding the book repository as a dependency

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;

	public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {

		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	// creates a product
	public Product createProduct(Product p) {
		return productRepository.save(p);
	}

	// finds all products that don't belong to a certain category
	public List<Product> findProductsNotInCategory(Category category) {
		return productRepository.findByCategoriesNotContains(category);
	}

	public List<Product> allProducts() {
		return productRepository.findAll();
	}

	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}

	public Product addCategoryToProduct(long id, long categoryId) {
		Optional<Product> p = productRepository.findById(id);
		Optional<Category> c = categoryRepository.findById(categoryId);
		if (p.isPresent() && c.isPresent()) {
			Product product = p.get();
			Category category = c.get();
			product.getCategories().add(category);
			return productRepository.save(product);
		} else {
			return null;
		}

	}

}
