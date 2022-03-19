package com.sanad.productsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sanad.productsandcategories.models.Category;
import com.sanad.productsandcategories.models.Product;
import com.sanad.productsandcategories.services.CategoryService;
import com.sanad.productsandcategories.services.ProductService;

@Controller
public class MainController {
	private final CategoryService categoryService;
	private final ProductService productService;

	public MainController(CategoryService categoryService, ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}

	// Categories routes

	@GetMapping("/")
	public String landing() {

		return "/other/home.jsp";
	}

	@GetMapping("/categories")
	public String categories(Model model) {

		List<Category> categories = categoryService.allCategories();
		model.addAttribute("categories", categories);

		return "/categories/categories.jsp";
	}

	@GetMapping("/categories/new")
	public String index(@ModelAttribute("category") Category category) {
		return "/categories/newCategory.jsp";
	}

	@PostMapping("/categories")
	public String create(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "/categories/newCategory.jsp";
		} else {
			categoryService.createCategory(category);
			return "redirect:/categories";
		}
	}

	@GetMapping("/categories/{id}")
	public String index(@PathVariable("id") Long id, Model model) {
		Category category = categoryService.findCategory(id);
		List<Product> products = productService.findProductsNotInCategory(category);
		model.addAttribute("category", category);
		model.addAttribute("products", products);
		return "/categories/categoryDetails.jsp";
	}

	@PutMapping("/categories/{id}")
	public String addProduct(@PathVariable("id") Long id, @RequestParam(value = "id") Long productId) {
		categoryService.addProductToCategory(id, productId);
		return String.format("redirect:/categories/%d", id);

	}

	// Products routes
	@GetMapping("/products")
	public String newNinja(Model model) {
		List<Product> products = productService.allProducts();
		model.addAttribute("products", products);
		return "/products/products.jsp";
	}

	@GetMapping("/products/new")
	public String newNinja(@ModelAttribute("product") Product product) {

		return "/products/newProduct.jsp";
	}

	@PostMapping("/products")
	public String create(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "/products/newProduct.jsp";
		} else {
			productService.createProduct(product);
			return "redirect:/products";
		}
	}

	@GetMapping("/products/{id}")
	public String productDetails(@PathVariable("id") Long id, Model model) {
		Product product = productService.findProduct(id);
		List<Category> categories = categoryService.findCategoriesNotInProduct(product);
		model.addAttribute("categories", categories);
		model.addAttribute("product", product);
		return "/products/productDetails.jsp";
	}

	@PutMapping("/products/{id}")
	public String addCategory(@PathVariable("id") Long id, @RequestParam(value = "id") Long categoryId) {
		productService.addCategoryToProduct(id, categoryId);
		return String.format("redirect:/products/%d", id);

	}
//
}
