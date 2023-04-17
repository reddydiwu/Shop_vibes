package com.project.ShopVibes.dto;

public class CategoryDto {

	private String categoryName;
	private String description;
	private String imageUrl;
	
	public CategoryDto(String categoryName, String description, String imageUrl) {
		super();
		this.categoryName = categoryName;
		this.description = description;
		this.imageUrl = imageUrl;
	}
	public CategoryDto() {
		super();
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
}
