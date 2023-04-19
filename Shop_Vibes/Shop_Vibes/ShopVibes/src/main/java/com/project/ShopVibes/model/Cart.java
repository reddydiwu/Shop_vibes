package com.project.ShopVibes.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserDtls user;
	
	private int quantity;
    

}
