package com.project.ShopVibes.service;

import com.project.ShopVibes.dto.ProductDto;
import com.project.ShopVibes.model.Category;
import com.project.ShopVibes.model.Product;

public interface ProductService {

	//Product saveProducts(ProductDto productDto,Category category);
	Product saveProduct(ProductDto productDto);
}
