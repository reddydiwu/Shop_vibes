package com.project.ShopVibes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.ShopVibes.dto.CategoryDto;
import com.project.ShopVibes.model.Category;
import com.project.ShopVibes.service.CategoryService;
import com.project.ShopVibes.service.CategoryServiceImpl;

@Controller
@RequestMapping("/shopvibes/category")
public class CategoryController {

	private CategoryService categoryService;
	
	public CategoryController(CategoryServiceImpl categoryService) {
		super();
		this.categoryService = categoryService;
	}

	@ModelAttribute("addcategory")
	public CategoryDto categoryDto() {
		return new CategoryDto();
	}
	
	@GetMapping
	public String showCategoryForm() {
		return "admin/category";
	}
	
	@PostMapping
	public String createCategory(@ModelAttribute("addcategory") CategoryDto categoryDto) {
		categoryService.save(categoryDto);
		return "redirect:/shopvibes/category?success";
	}
	
	@GetMapping("/edit/{id}")
	public String editStudentForm(@PathVariable int id, Model model) {
		model.addAttribute("category", categoryService.getCategoryById(id));
		return "admin/edit_category";
	}
	
	@PostMapping("/edit/{id}")
	public String updateCategory(@PathVariable int id, 
								@ModelAttribute("category") Category category, 
								Model model) {
		//get category from db
		Category existingcategory = categoryService.getCategoryById(id);
		existingcategory.setId(category.getId());
		existingcategory.setCategoryName(category.getCategoryName());
		existingcategory.setDescription(category.getDescription());
		existingcategory.setImageUrl(category.getImageUrl());
		categoryService.editCategory(existingcategory);
		return "redirect:/shopvibes/admin/listofcategories";
	}
	
	@GetMapping("/{id}")
	public String deleteCategory(@PathVariable int id) {
		categoryService.deleteCategoryById(id);
		return "redirect:/shopvibes/admin/listofcategories";
	}
}
