package com.project.ShopVibes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="product")

public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="product_name")
	private @NotBlank String productName;
	
	@Column(name="description")
	private @NotBlank String description;
	
	@Column(name="image_url")
	private @NotBlank String imageUrl;

	private @NotNull double price;

	//Many to one relationship
		@ManyToOne
		@JoinColumn(name= "category_id")
		Category category;
	
	public Product() {
		super();
	}

	

//	public Product(Integer id, @NotBlank String productName, @NotBlank String description, @NotBlank String imageUrl,
//			@NotNull double price) {
//		super();
//		this.id = id;
//		this.productName = productName;
//		this.description = description;
//		this.imageUrl = imageUrl;
//		this.price = price;
//	}



	public Product(@NotBlank String productName, @NotBlank String description, double d, @NotBlank String imageUrl,
			@NotNull double price) {
		super();
		this.productName = productName;
		this.description = description;
		this.imageUrl = imageUrl;
		this.price = price;
	}



	public Product(Integer id, @NotBlank String productName, @NotBlank String description, @NotBlank String imageUrl,
			@NotNull double price, Category category) {
		super();
		this.id = id;
		this.productName = productName;
		this.description = description;
		this.imageUrl = imageUrl;
		this.price = price;
		this.category = category;
	}



	public Product(@NotBlank String productName, @NotBlank String description, @NotBlank double price,
		@NotNull String imageUrl, Category categoryId) {
	super();
	this.productName = productName;
	this.description = description;
	this.price = price;
	this.imageUrl = imageUrl;
	
	
	this.category = categoryId;
}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}



	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}
