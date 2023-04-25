package com.project.ShopVibes.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cartitem")
public class CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int quantity;
	@Temporal(TemporalType.DATE)
	private Date date;
	@OneToOne(cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private Product product;
	
	
	
	
//	private List<Product> products = new ArrayList<>();
//	
//
//	public double getTotalPrice() {
//        double totalPrice = 0;
//        for (CartItem cartItem : products) {
//            totalPrice += cartItem.getProduct().getPrice() * cartItem.getQuantity();
//        }
//        return totalPrice;
//    }
//	
//	
	public CartItem(Integer id, int quantity, Date date, Product product) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.date = date;
		this.product = product;
		
	}

	


	public CartItem() {
		super();
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", product=" + product + "]";
	}

}
