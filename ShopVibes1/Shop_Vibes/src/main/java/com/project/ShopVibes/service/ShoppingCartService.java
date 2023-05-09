package com.project.ShopVibes.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ShopVibes.model.CartItem;
import com.project.ShopVibes.model.Product;
import com.project.ShopVibes.repository.CartItemRepository;
import com.project.ShopVibes.repository.UserRepository;

@Service
public class ShoppingCartService {

	@Autowired
	private UserServiceImpl userServiceimpl;
	@Autowired
	private ProductService productService;
	@Autowired CartItemRepository cartItemRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	
//	public ShoppingCart addShoppingCartFirstTime(Integer id, String sessionToken, int quantity) {
//		ShoppingCart shoppingCart = new ShoppingCart();
//		CartItem cartItem = new CartItem();
//		cartItem.setQuantity(quantity);
//		cartItem.setDate(new Date());
//		cartItem.setProduct(productService.getProductById(id));
//		shoppingCart.getItems().add(cartItem);
//		shoppingCart.setSessionToken(sessionToken);
//		shoppingCart.setDate(new Date());
//		return shoppingCartRepository.save(shoppingCart);
//
//	}

	public CartItem addShoppingCartFirstTime(Integer id, int quantity) {
	
	CartItem cartItem = new CartItem();
	cartItem.setQuantity(quantity);
	cartItem.setDate(new Date());
	cartItem.setProduct(productService.getProductById(id));
	return cartItemRepository.save(cartItem);

}
	public CartItem addShoppingCartItem(Integer id, int quantity) {
	    Product product = productService.getProductById(id);
	    Optional<CartItem> optionalCartItem = cartItemRepository.findByProduct(product);
	    CartItem cartItem;
	    
	    if (optionalCartItem.isPresent()) {
	        cartItem = optionalCartItem.get();
	        cartItem.setQuantity(cartItem.getQuantity() + quantity);
	        cartItemRepository.save(cartItem);
	    } else {
	        cartItem = new CartItem();
	        cartItem.setQuantity(quantity);
	        cartItem.setDate(new Date());
	        cartItem.setProduct(product);
	        cartItemRepository.save(cartItem);
	    }
	    
	    return cartItem;
	}
	
	
//	public ShoppingCart addToExistingShoppingCart(Integer id, String sessionToken, int quantity) {
//
//		ShoppingCart shoppingCart = shoppingCartRepository.findBySessionToken(sessionToken);
//		Product p = productService.getProductById(id);
//		Boolean productDoesExistInTheCart = false;
//		if (shoppingCart != null) {
//		    Set<CartItem> items = shoppingCart.getItems();
//			for (CartItem item : items) {
//				if (item.getProduct().equals(p)) {
//					productDoesExistInTheCart = true;
//					item.setQuantity(item.getQuantity() + quantity);
//					shoppingCart.setItems(items);
//					return shoppingCartRepository.saveAndFlush(shoppingCart);  
//				}
//				
//			}
//		}
//		if(!productDoesExistInTheCart && (shoppingCart != null))
//		{
//			CartItem cartItem1 = new CartItem();
//			cartItem1.setDate(new Date());
//			cartItem1.setQuantity(quantity);
//			cartItem1.setProduct(p);
//			shoppingCart.getItems().add(cartItem1);
//			return shoppingCartRepository.saveAndFlush(shoppingCart);
//		}
//		
//		return this.addShoppingCartFirstTime(id, sessionToken, quantity);
//
//	}

//	public ShoppingCart getShoppingCartBySessionTokent(String sessionToken) {
//		
//		return  shoppingCartRepository.findBySessionToken(sessionToken);
//	}
//
//	public CartItem updateShoppingCartItem(Integer id, int quantity) {
//		CartItem cartItem = cartItemRepository.findById(id).get();
//		cartItem.setQuantity(quantity);
//		return cartItemRepository.saveAndFlush(cartItem);
//		
//	}
//
//	public ShoppingCart removeCartIemFromShoppingCart(Integer id, String sessionToken) {
//		ShoppingCart shoppingCart = shoppingCartRepository.findBySessionToken(sessionToken);
//		Set<CartItem> items = shoppingCart.getItems();
//		CartItem cartItem = null;
//		for(CartItem item : items) {
//			if(item.getId()==id) {
//				cartItem = item;
//			}
//		}
//		items.remove(cartItem);
//		cartItemRepository.delete(cartItem);
//	    shoppingCart.setItems(items);
//	    return shoppingCartRepository.save(shoppingCart);
//	}
//
//	
	public void deletecartitembyid(int id) {
		cartItemRepository.deleteById(id);
	}
//	
//	public void clearShoppingCart(String sessionToken) {
//		ShoppingCart sh = shoppingCartRepository.findBySessionToken(sessionToken);
//		shoppingCartRepository.delete(sh);
//		
//	}
}
