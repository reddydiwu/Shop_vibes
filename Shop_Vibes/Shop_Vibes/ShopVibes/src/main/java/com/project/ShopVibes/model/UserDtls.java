package com.project.ShopVibes.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class UserDtls implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String firstName;

	private String lastName;

	@Email
	private String email;

	// private String address;

	// private String qualification;

//	@NotBlank(message = "Password is required")
//	@Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters")
//	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])", message = "Password must contain at least one digit, one lowercase letter, one uppercase letter, one special character")
	private String password;

	private String role;

}
