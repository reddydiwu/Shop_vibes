package com.project.ShopVibes.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.ShopVibes.repository.CartItemRepository;
import com.project.ShopVibes.repository.ShoppingCartRepository;
import com.project.ShopVibes.service.ShoppingCartService;

@Controller
@RequestMapping(path="/shopvibes/user")
public class CartController {

	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@PostMapping("/addToCart/{id}/{quantity}")
	public String addToCart(HttpServletRequest request, Model model, @PathVariable Integer id,
			@PathVariable int quantity,String sessionToken) {
		
		// sessiontToken
		 sessionToken = (String) request.getSession(true).getAttribute("sessiontToken");
		if (sessionToken == null) {

			sessionToken = UUID.randomUUID().toString();
			request.getSession().setAttribute("sessiontToken", sessionToken);
			shoppingCartService.addShoppingCartFirstTime(id, sessionToken, quantity);
		} else {
			shoppingCartService.addToExistingShoppingCart(id, sessionToken, quantity);
		}
		System.out.println("Success");
		return "redirect:/shopvibes/user/addtocart";
	}
	
	
	
	
//	@PostMapping("/addToCart/{id}/{quantity}")
//	public String addToCart(HttpServletRequest request, Model model, @PathVariable Integer id,
//			@PathVariable int quantity) {
//		
//	 	if(cartItemRepository.getProductById(id)==null) {
//	 		shoppingCartService.addShoppingCartFirstTime(id,quantity);
//	 	}
////	 	else {
////	 		shoppingCartService.addToExistingShoppingCart(id, quantity);
////	 	}
//		
//		System.out.println("Success");
//		return "redirect:/shopvibes/user/addtocart";
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@ModelAttribute("addtocart")
//	public CartItem cartItem() {
//		return new CartItem();
//	}
//	
//	@PostMapping("/addToCart")
//	public String addToCart(@ModelAttribute("addtocart") CartItem cartItem, @RequestParam("id") Integer id,
//			@RequestParam("quantity") int quantity,String sessionToken) {
//		shoppingCartService.addShoppingCartFirstTime(id, sessionToken, quantity);
//		return "redirect:user/shopvibes/home";
//	}
//	
//	
	
	@GetMapping("/shoppingCart")
	public String showShoopingCartView(HttpServletRequest request, Model model) {
		
		return "user/cart";
	}
	
	
	@PostMapping("/updateShoppingCart")
	public String updateCartItem(@RequestParam("item_id") int id,
			@RequestParam("quantity") int quantity) {
		
		shoppingCartService.updateShoppingCartItem(id,quantity);
		return "redirect:shoppingCart";
	}
	@GetMapping("/removeCartItem/{id}/{sessionToken}")
	public String removeItem(@PathVariable("id") int id, HttpServletRequest request,@PathVariable("sessionToken") String sessionToken ) {
		sessionToken = (String) request.getSession(false).getAttribute("sessiontToken");
		System.out.println("got here ");
		shoppingCartService.removeCartIemFromShoppingCart(id,sessionToken);
		return "redirect:/shoppingCart";
	}
	
	@GetMapping("/clearShoppingCart")
	public String clearShoopiString(HttpServletRequest request) {
		String sessionToken = (String) request.getSession(false).getAttribute("sessiontToken");
		request.getSession(false).removeAttribute("sessiontToken");
		shoppingCartService.clearShoppingCart(sessionToken);
		return "redirect:/shoppingCart";
	}
	
	@GetMapping("/deletefromcart/{id}")
	public String deleteCategory(@PathVariable int id) {
		
		shoppingCartRepository.deleteProductById(id);
	//	cartItemRepository.deleteById(id);
	//	cartItemRepository.deleteProductById(id);
		System.out.println("Deleted");
		return "redirect:/shopvibes/user/addtocart";
	}
}
