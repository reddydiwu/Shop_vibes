package com.project.ShopVibes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ShopVibes.model.CartItem;
import com.project.ShopVibes.model.Product;
import com.project.ShopVibes.model.UserDtls;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer>{

	Optional<CartItem> findByProduct(Product product);
	//void deleteByProduct_id(int id);


}
