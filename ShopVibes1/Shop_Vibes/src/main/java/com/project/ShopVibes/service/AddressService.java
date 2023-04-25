package com.project.ShopVibes.service;

import java.util.List;

import com.project.ShopVibes.dto.AddressDto;
import com.project.ShopVibes.model.Address;
import com.project.ShopVibes.model.UserDtls;

public interface AddressService {

	Address saveAddress(AddressDto addressDto);
	List<Address> getAllAddress();
	UserDtls getUserById(int id);
}
