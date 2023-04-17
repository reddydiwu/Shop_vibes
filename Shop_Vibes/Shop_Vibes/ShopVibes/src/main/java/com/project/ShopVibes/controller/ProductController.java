package com.project.ShopVibes.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.ShopVibes.dto.ProductDto;
import com.project.ShopVibes.model.Category;
import com.project.ShopVibes.repository.CategoryRepository;
import com.project.ShopVibes.service.ProductService;
import com.project.ShopVibes.service.ProductServiceImpl;

@Controller
@RequestMapping("/shopvibes/product")
public class ProductController {
//	private ProductRepository productRepository;
//
//	public ProductController(ProductRepository productRepository) {
//		super();
//		this.productRepository = productRepository;
//	}

	private ProductService productService;
	
	
	
	public ProductController(ProductServiceImpl productService) {
	super();
	this.productService = productService;
}

	@Autowired
	private CategoryRepository categoryRepository;

	public ProductController() {
		super();
	}

	public ProductController(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

//public ProductController(ProductService productService) {
//		super();
//		this.productService = productService;
//	}

	@ModelAttribute("addproduct")
	public ProductDto productDto() {
		return new ProductDto();
	}

	@GetMapping
	public String showProductForm() {
		return "admin/product";
	}

//	@PostMapping
//	public String createProduct(@ModelAttribute("addproduct") ProductDto productDto, Category category) {
//		
//		productService.saveProducts(productDto,category);
//		return "redirect:/product?success";
//	}

	@PostMapping
	public String createProduct(@ModelAttribute("addproduct") ProductDto productDto) {
		Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());

		if (!optionalCategory.isPresent()) {
			return ("Category does not exist");
		}
		System.out.println(productDto.toString());
		productService.saveProduct(productDto);
		return "redirect:/shopvibes/product?success";

	}

//	@PostMapping("/create")
//	public ResponseEntity<ApiResponse> createCategory(@RequestBody Category category) {
//		categoryService.createCategory(category);
//		return new ResponseEntity<>(new ApiResponse(true, "new category created"),HttpStatus.CREATED);
//	}
//	
//	@GetMapping("/list")
//	public List<Category> listCategory() {
//		return categoryService.listcategory();	 
//	}
//	
//	
//	
//	@PutMapping("update/{id}")
//	public ResponseEntity<ApiResponse> updateCategory(@PathVariable("id") int id, @RequestBody Category category) {
//		System.out.println("Category id "+id);
//		
//		if(!categoryService.findById(id)){
//			return new ResponseEntity<>(new ApiResponse(false, "category does not exist"),HttpStatus.NOT_FOUND);
//		}
//		
//		categoryService.editCategory(id, category);
//		return new ResponseEntity<>(new ApiResponse(true, "Category has been updated"),HttpStatus.OK);
//	}
}
