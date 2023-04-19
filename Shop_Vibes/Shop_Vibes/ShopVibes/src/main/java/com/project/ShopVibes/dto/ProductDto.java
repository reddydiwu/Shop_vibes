package com.project.ShopVibes.dto;

public class ProductDto {

	private String productName;
	private String description;
	private String imageUrl;
	private double price;
	private String category;
	
	
	
	public ProductDto() {
		super();
	}
	public ProductDto(String productName, String description, String imageUrl,double price, String category) {
		super();
		this.productName = productName;
		this.description = description;
		this.imageUrl = imageUrl;
		this.price=price;
		this.category = category;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
