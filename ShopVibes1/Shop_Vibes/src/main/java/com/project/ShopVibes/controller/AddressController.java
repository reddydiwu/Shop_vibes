package com.project.ShopVibes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.ShopVibes.dto.AddressDto;
import com.project.ShopVibes.model.Address;
import com.project.ShopVibes.repository.AddressRepository;
import com.project.ShopVibes.service.AddressServiceImpl;

@Controller
@RequestMapping("/cust")
public class AddressController {

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private AddressServiceImpl addressService;
	
	
	@ModelAttribute("address")
	public AddressDto addresssDto() {
		return new AddressDto();
	}
	
	@GetMapping("address")
	public String showAddressForm() {
		return "user/address";
	}
	
	@PostMapping("/address")
	public String createProduct(@ModelAttribute("address") AddressDto addressDto) {
		addressService.saveAddress(addressDto);
		return "redirect:/cust/addtocart?success";
	}
}
