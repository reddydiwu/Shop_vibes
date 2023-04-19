package com.project.ShopVibes.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ShopVibes.dto.AddToCartDto;
import com.project.ShopVibes.dto.CartDto;
import com.project.ShopVibes.dto.CartItemDto;
import com.project.ShopVibes.model.Cart;
import com.project.ShopVibes.model.Product;
import com.project.ShopVibes.model.UserDtls;
import com.project.ShopVibes.repository.CartRepository;
import com.project.ShopVibes.repository.ProductRepository;

@Service
public class CartService {

	@Autowired
	private ProductServiceImpl productService;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ProductRepository productRepository;
	
	public boolean findById(int id) {

		return productRepository.findById(id).isPresent();
	}

	public void addToCart(AddToCartDto addToCartDto, UserDtls user) {

		// validate if the product id is valid
		Product product = productService.findById(addToCartDto.getProductId());
		// save the cart

		Cart cart = new Cart();
		cart.setProduct(product);
		cart.setUser(user);
		cart.setQuantity(addToCartDto.getQuantity());
		cart.setCreatedDate(new Date());
		cartRepository.save(cart);
	}

	public CartDto listCartItems(UserDtls user) {
		List<Cart> cartList = cartRepository.findAllByUserOrderByCreatedDateDesc(user);

		// change cart to cartdto
		List<CartItemDto> cartItems = new ArrayList<>();
		double totalCost = 0;
		for (Cart cart : cartList) {
			CartItemDto cartItemDto = new CartItemDto(cart);
			totalCost += cartItemDto.getQuantity() * cart.getProduct().getPrice();
			cartItems.add(cartItemDto);
		}
		CartDto cartDto = new CartDto();
		cartDto.setTotalCost(totalCost);
		cartDto.setCartItems(cartItems);

		return cartDto;
	}
}
