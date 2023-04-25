package com.project.ShopVibes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ShopVibes.model.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer>{

}