package com.project.ShopVibes.dto;

import javax.validation.constraints.NotNull;

import com.project.ShopVibes.model.Category;

public class ProductDto {

	private Integer id;
	private String productName;
	private String description;
	private String imageUrl;
	private double price;
	private @NotNull Integer categoryId;
	
	
	public ProductDto(String productName, String description, String imageUrl, double price,
			@NotNull Integer categoryId) {
		super();
		this.productName = productName;
		this.description = description;
		this.imageUrl = imageUrl;
		this.price = price;
		this.categoryId = categoryId;
	}
	public ProductDto() {
		super();
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}

