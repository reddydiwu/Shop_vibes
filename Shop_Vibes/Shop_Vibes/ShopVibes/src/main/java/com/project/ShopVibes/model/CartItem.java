package com.project.ShopVibes.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cartitem")
public class CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private int quantity;
	@Temporal(TemporalType.DATE)
	private Date date;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id",nullable=false, updatable=false)
	private Product product;
	
	private Set<CartItem> items = new HashSet<CartItem>();
	
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

	

	public CartItem(int quantity, Date date, Product product, Set<CartItem> items) {
		super();
		this.quantity = quantity;
		this.date = date;
		this.product = product;
		this.items = items;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", product=" + product + "]";
	}



	public Set<CartItem> getItems() {
		return items;
	}



	public void setItems(Set<CartItem> items) {
		this.items = items;
	}

}
