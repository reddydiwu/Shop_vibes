package com.project.ShopVibes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.ShopVibes.model.UserDtls;
import com.project.ShopVibes.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncode;

	@Override
	public UserDtls createUser(UserDtls user) {

		user.setPassword(passwordEncode.encode(user.getPassword()));
//		user.setPassword(user.getPassword());

		System.out.println(user.getPassword());
		user.setRole("ROLE_USER");

		return userRepo.save(user);
	}

	@Override
	public boolean checkEmail(String email) {

		return userRepo.existsByEmail(email);
	}

	@Override
	public UserDtls getUserById(Integer userId) {
		
		return userRepo.findById(userId).get();
	}

	@Override
	public UserDtls editUser(UserDtls user) {
		
		return userRepo.save(user);
	}

	@Override
	public void deleteUserById(int id) {
		userRepo.deleteById(id);
		
	}

//	@Override
//	public String getUserByRole(String role) {
//		
//		 userRepo.findByRole(role);
//	}

}