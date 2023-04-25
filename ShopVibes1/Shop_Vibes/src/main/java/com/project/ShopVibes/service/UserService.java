package com.project.ShopVibes.service;

import com.project.ShopVibes.model.UserDtls;

public interface UserService {

	public UserDtls createUser(UserDtls user);

	public boolean checkEmail(String email);

	public UserDtls getUserById(Integer userId);
}
