package com.project.ShopVibes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.ShopVibes.dto.ProductDto;
import com.project.ShopVibes.model.Product;
import com.project.ShopVibes.service.ProductService;
import com.project.ShopVibes.service.ProductServiceImpl;

@Controller
@RequestMapping("/shopvibes/product")
public class ProductController {

	private ProductService productService;
	
	public ProductController(ProductServiceImpl productService) {
		super();
		this.productService = productService;
	}

	@ModelAttribute("addproduct")
	public ProductDto productDto() {
		return new ProductDto();
	}
	
	@GetMapping
	public String showProductForm() {
		return "admin/product";
	}
	
	@PostMapping
	public String createProduct(@ModelAttribute("addproduct") ProductDto productDto) {
		productService.save(productDto);
		return "redirect:/shopvibes/product?success";
	}
	
	@GetMapping("/edit/{id}")
	public String editProductForm(@PathVariable int id, Model model) {
		model.addAttribute("product", productService.getProductById(id));
		return "admin/edit_product";
	}
	
	@PostMapping("/edit/{id}")
	public String updateCategory(@PathVariable int id, 
								@ModelAttribute("product") Product product, 
								Model model) {
		//get category from db
		Product existingproduct = productService.getProductById(id);
		existingproduct.setId(product.getId());
		existingproduct.setProductName(product.getProductName());
		existingproduct.setDescription(product.getDescription());
		existingproduct.setImageUrl(product.getImageUrl());
		existingproduct.setPrice(product.getPrice());
		existingproduct.setCategory(product.getCategory());
		productService.editProduct(existingproduct);
		return "redirect:/shopvibes/admin/listofproducts";
	}
	
	@GetMapping("/{id}")
	public String deleteProduct(@PathVariable int id) {
		productService.deleteProductById(id);
		return "redirect:/shopvibes/admin/listofproducts";
	}
}
