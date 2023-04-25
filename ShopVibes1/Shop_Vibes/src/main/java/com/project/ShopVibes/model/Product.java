package com.project.ShopVibes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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

	private double price;
	private String category;
	public Product() {
		super();
	}

	

	public Product(Integer id, @NotBlank String productName, @NotBlank String description, @NotBlank String imageUrl,
			double price, String category) {
		super();
		this.id = id;
		this.productName = productName;
		this.description = description;
		this.imageUrl = imageUrl;
		this.price = price;
		this.category = category;
	
	}



	public Product(@NotBlank String productName, @NotBlank String description, @NotBlank String imageUrl, double price,
			String category) {
		super();
		this.productName = productName;
		this.description = description;
		this.imageUrl = imageUrl;
		this.price = price;
		this.category = category;
	
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	

	
	
}
