package com.project.ShopVibes.dto;

import com.project.ShopVibes.model.UserDtls;

public class AddressDto {

	private int id;
	private Long phno;
	private String street;
	private String city;
	private String state;
	private String country;
	private UserDtls user;
	
	
	
	public AddressDto() {
		super();
	}
	public AddressDto(int id, Long phno, String street, String city, String state, String country, UserDtls user) {
		super();
		this.id = id;
		this.phno = phno;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.user = user;
	}
	public AddressDto(Long phno, String street, String city, String state, String country, UserDtls user) {
		super();
		this.phno = phno;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getPhno() {
		return phno;
	}
	public void setPhno(Long phno) {
		this.phno = phno;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public UserDtls getUser() {
		return user;
	}
	public void setUser(UserDtls user) {
		this.user = user;
	}

	
	
}
