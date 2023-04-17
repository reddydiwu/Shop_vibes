package com.project.ShopVibes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ShopVibes.dto.ProductDto;
import com.project.ShopVibes.model.Category;
import com.project.ShopVibes.model.Product;
import com.project.ShopVibes.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	
	private ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}
	
//	public ProductServiceImpl() {
//		super();
//	}

	public List<Product> listcategory(){
		return productRepository.findAll();
	}

	public boolean findById(int id) {
		
		return productRepository.findById(id).isPresent();
	}

	@Override
	public Product saveProduct(ProductDto productDto) {
		
		Product product = new Product(productDto.getProductName(), productDto.getImageUrl(), 
				productDto.getPrice(), productDto.getDescription(),
				productDto.getCategoryId());
	
		return productRepository.save(product);
		
	}

//	public void createProduct(ProductDto productDto, Category category) {
//		Product product = new Product();
//		product.setDescription(productDto.getDescription());
//		product.setImageUrl(productDto.getImageUrl());
//		product.setProductName(productDto.getProductName());
//		product.setCategory(category);
//		product.setPrice(productDto.getPrice());
//		productRepository.save(product);
//	}
//
//	//Convert product into productDto
//		public ProductDto getProductDto(Product product) {
//			ProductDto productDto=new ProductDto();
//			productDto.setDescription(product.getDescription());
//			productDto.setImageUrl(product.getImageUrl());
//			productDto.setProductName(product.getProductName());
//			productDto.setCategoryId(product.getCategory().getId());
//			productDto.setPrice(product.getPrice());
//			productDto.setId(product.getId());
//			return productDto;
//		}

	
}

