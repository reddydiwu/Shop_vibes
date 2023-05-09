package com.project.ShopVibes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ShopVibes.model.Address;
import com.project.ShopVibes.model.UserDtls;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

	UserDtls findByUserId(int id);
	
	
	
}
