package com.project.ShopVibes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ShopVibes.model.CartItem;
import com.project.ShopVibes.model.Product;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer>{
	Product getProductById(int id);
	void deleteProductById(int id);
}
