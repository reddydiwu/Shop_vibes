package com.project.ShopVibes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ShopVibes.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

	Category getById(int id);

}