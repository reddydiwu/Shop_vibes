package com.project.ShopVibes.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.ShopVibes.model.UserDtls;
import com.project.ShopVibes.repository.UserRepository;
import com.project.ShopVibes.service.UserService;


@Controller
@RequestMapping("/shopvibes")
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@ModelAttribute
	private void userDetails(Model m, Principal p) {
		if(p!=null) {
		String email = p.getName();
		UserDtls user = userRepo.findByEmail(email);

		m.addAttribute("user", user);
		}
	}
	
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/signin")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/createUser")
	public String createuser(@ModelAttribute UserDtls user, HttpSession session) {

		// System.out.println(user);

		boolean f = userService.checkEmail(user.getEmail());

		if (f) {
			session.setAttribute("msg", "Email Id alreday exists");
		}

		else {
			UserDtls userDtls = userService.createUser(user);
			if (userDtls != null) {
				session.setAttribute("msg", "Register Sucessfully");
			} else {
				session.setAttribute("msg", "Something wrong on server");
			}
		}

		return "redirect:/register";
	}

	@GetMapping("/forgot")
	public String forgot() {
		return "forgot";
	}
	
	@GetMapping("/resetpassword/{id}")
	public String reset(@PathVariable int id, Model m) {
		m.addAttribute("id",id);
		return "reset_password";
	}
	
	@PostMapping("/forgot")
	public String forgotPassword(@RequestParam String email,HttpSession session) {
		UserDtls user =userRepo.findByEmail(email);
		
		if(user!=null) {
			return "redirect:/resetpassword/"+user.getId();
		}else {
			session.setAttribute("msg", "Invalid Email id");
			return "forgot";
		}
		
	}
	
	@PostMapping("/changepassword")
	public String resetpassword(@RequestParam String password,@RequestParam Integer id,HttpSession session) {
		
		UserDtls user = userRepo.findById(id).get();
		
		String encryptpassword = passwordEncoder.encode(password);
		
		user.setPassword(encryptpassword);
		
		UserDtls updateUser = userRepo.save(user);
		
		if(updateUser!=null)
		{
			session.setAttribute("msg", "Password Changed Successfully");
		}
		return "redirect:/signin";
	}
}
