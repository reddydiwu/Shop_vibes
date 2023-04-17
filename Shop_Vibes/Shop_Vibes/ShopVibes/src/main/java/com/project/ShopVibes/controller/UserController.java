package com.project.ShopVibes.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.ShopVibes.model.UserDtls;
import com.project.ShopVibes.repository.UserRepository;

@Controller
@RequestMapping("/shopvibes/user")
public class UserController {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	//principal will create an user object
	
	@ModelAttribute
	private void userDetails(Model m, Principal p) {
		String email = p.getName();
		UserDtls user = userRepo.findByEmail(email);

		m.addAttribute("user", user);

	}

	@GetMapping("/")
	public String home() {
		return "user/home";
	}

	@GetMapping("/changePassword")
	public String loadChangePassword() {
		return "user/change_password";
	}

	//will get user details by using principal 
	
	@PostMapping("/updatePassword")
	public String changePassword(Principal p, @RequestParam("oldPassword") String oldPassword, 
								@RequestParam("newPassword") String newPassword,
								HttpSession session) {
		
		String email = p.getName();
		UserDtls loginUser = userRepo.findByEmail(email);
		
		boolean f = passwordEncoder.matches(oldPassword, loginUser.getPassword());
		
		if(f) {
			loginUser.setPassword(passwordEncoder.encode(newPassword));
			UserDtls updatePasswordUser = userRepo.save(loginUser);
			
			if(updatePasswordUser!=null) {
				session.setAttribute("msg", "Password Change success");
			}else {
				session.setAttribute("msg", "Something went wrong");

			}
			
		}else {
			session.setAttribute("msg", "Old Password is incorrect");

		}
		
		return "redirect:/shopvibes/user/changePassword";
	}
	
	
}
