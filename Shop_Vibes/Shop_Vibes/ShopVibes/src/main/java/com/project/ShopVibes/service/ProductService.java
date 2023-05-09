package com.project.ShopVibes.service;

import java.util.List;

import com.project.ShopVibes.dto.ProductDto;
import com.project.ShopVibes.model.Product;

public interface ProductService {

	Product save(ProductDto productDto);

	List<Product> getAllProduct();
	
	Product getProductById(int id);
	Product editProduct(Product category);
	
	void deleteProductById(int id);

}

