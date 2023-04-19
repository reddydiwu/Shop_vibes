package com.project.ShopVibes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ShopVibes.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product getById(int id);

}