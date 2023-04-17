package com.project.ShopVibes.service;

import java.util.List;

import com.project.ShopVibes.dto.CategoryDto;
import com.project.ShopVibes.model.Category;

public interface CategoryService {

	Category save(CategoryDto categoryDto);

	List<Category> getAllCategories();
	
	Category getCategoryById(int id);
	Category editCategory(Category category);
	
	void deleteCategoryById(int id);
}

