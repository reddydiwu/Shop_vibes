package com.project.ShopVibes.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.ShopVibes.model.CartItem;
import com.project.ShopVibes.repository.CartItemRepository;
import com.project.ShopVibes.service.ShoppingCartService;

@Controller
@RequestMapping(path="/shopvibes/user")
public class CartController {

	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	
	@PostMapping("/addToCart/{id}/{quantity}")
	public String addToCart(HttpServletRequest request, Model model, @PathVariable Integer id,
			@PathVariable int quantity) {
		
	 	if(cartItemRepository.findById(id)==null) {
	 		shoppingCartService.addShoppingCartFirstTime(id,quantity);
	 	}
	 	else {
	 		shoppingCartService.addShoppingCartItem(id, quantity);
	 	}
		
		System.out.println("Success");
		return "redirect:/shopvibes/user/addtocart";
	}

	@PostMapping("/{id}")
	public String deletecartitembyid(@PathVariable int id) {
	//	shoppingCartService.deletecartitembyid(id);
	//	cartItemRepository.deleteByProduct_id(id);
		System.out.println("Before");
		shoppingCartService.deletecartitembyid(id);
		
		System.out.println("After");
		return "redirect:/shopvibes/user/addtocart";
	}
}
