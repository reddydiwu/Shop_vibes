package com.project.ShopVibes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ShopVibes.dto.ProductDto;
import com.project.ShopVibes.exceptions.ProductNotExistsException;
import com.project.ShopVibes.model.Product;
import com.project.ShopVibes.repository.ProductRepository;
import com.project.ShopVibes.repository.UserRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	private ProductRepository productRepository;
	
	@Autowired
	private UserService userService;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;    
	}
	
	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	public boolean findById(int id) {
		
		return productRepository.findById(id).isPresent();
	}

	@Override
	public Product save(ProductDto productDto) {
		Product product = new Product(
										productDto.getProductName(),
										productDto.getDescription(),
										productDto.getImageUrl(),
										productDto.getPrice(),
										productDto.getCategory());
		return productRepository.save(product);
	}

	@Override
	public Product editProduct(Product category) {
		
		return productRepository.save(category);
	}

	@Override
	public void deleteProductById(int id) {
		productRepository.deleteById(id);
		
	}

	@Override
	public Product getProductById(int id) {
		  return productRepository.findById(id).get();
	}

public Product findById(Integer productId) throws ProductNotExistsException{
		
		Optional<Product> optional= productRepository.findById(productId);
		if(optional.isEmpty()) {
			throw new ProductNotExistsException("Product id is invalid" +productId);
		}
		return optional.get();
	}
	
}

