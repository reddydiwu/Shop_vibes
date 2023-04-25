package com.project.ShopVibes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ShopVibes.dto.AddressDto;
import com.project.ShopVibes.model.Address;
import com.project.ShopVibes.model.UserDtls;
import com.project.ShopVibes.repository.AddressRepository;
import com.project.ShopVibes.repository.UserRepository;

@Service
public class AddressServiceImpl implements AddressService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserServiceImpl userServiceimpl;
	@Autowired
	private AddressRepository addressRepository;
	

	@Override
	public Address saveAddress(AddressDto addressDto) {
		
		Address address = new Address(
										addressDto.getPhno(),
										addressDto.getStreet(),
										addressDto.getCity(),
										addressDto.getState(),
										addressDto.getCountry(),
										addressDto.getUser());
		
		return addressRepository.save(address);
	}

	@Override
	public UserDtls getUserById(int id) {
		
		return null;
	}

	@Override
	public List<Address> getAllAddress() {
		return addressRepository.findAll();
	}
	
}
