package com.project.ShopVibes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.ShopVibes.dto.AddToCartDto;
import com.project.ShopVibes.dto.ProductDto;
import com.project.ShopVibes.model.UserDtls;
import com.project.ShopVibes.service.CartService;
import com.project.ShopVibes.service.ProductService;
import com.project.ShopVibes.service.ProductServiceImpl;
import com.project.ShopVibes.service.UserService;

@Controller
@RequestMapping("/shopvibes/cart")
public class CartController {

	@Autowired
	private ProductServiceImpl productService;
	
	
	
	public CartController(ProductServiceImpl productService) {
		super();
		this.productService = productService;
	}

	private UserService userService;
	
	public CartController(UserService userService) {
		super();
		this.userService = userService;
	}

	private CartService cartService;

	public CartController(CartService cartService) {
		super();
		this.cartService = cartService;
	}
	
	public CartController() {		
	}

	@ModelAttribute("addtocart")
	public ProductDto productDto() {
		return new ProductDto();
	}
	
	@PostMapping("/add")
	public String addToCart(@ModelAttribute("addtocart") AddToCartDto addToCartDto,int id) {
		UserDtls user = userService.getUserById(id);
		cartService.addToCart(addToCartDto, user);
		return "redirect:/shopvibes/cart?success";
	}
	
	@GetMapping("/add/{id}")
	public String addToCart(@PathVariable int id, Model model) {
		model.addAttribute("cart",productService.findById(id));
		return "user/shopvibes/cart";
	}
}
