package com.project.ShopVibes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ShopVibes.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product getById(int id);

}