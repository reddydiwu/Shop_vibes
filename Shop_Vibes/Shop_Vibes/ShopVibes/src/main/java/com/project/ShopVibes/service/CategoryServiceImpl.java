package com.project.ShopVibes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.ShopVibes.dto.CategoryDto;
import com.project.ShopVibes.model.Category;
import com.project.ShopVibes.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	
	private CategoryRepository categoryRepository;
	
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}
	
	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

//	public void editCategory(int id, Category updateCategory) {
//		
//		Category category = categoryRepository.getById(id);
//		category.setCategoryName(updateCategory.getCategoryName());
//		category.setDescription(updateCategory.getDescription());
//		category.setImageUrl(updateCategory.getImageUrl());
//		categoryRepository.save(category);
//	}

	public boolean findById(int id) {
		
		return categoryRepository.findById(id).isPresent();
	}

	@Override
	public Category save(CategoryDto categoryDto) {
		Category category = new Category(categoryDto.getCategoryName(),
							categoryDto.getDescription(),
							categoryDto.getImageUrl());
		return categoryRepository.save(category);
	}

	@Override
	public Category getCategoryById(int id) {
		
		return categoryRepository.findById(id).get();
	}

	@Override
	public Category editCategory(Category category) {
		
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategoryById(int id) {
		categoryRepository.deleteById(id);
		
	}

	
	
}

