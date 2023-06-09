package com.project.ShopVibes.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.ShopVibes.exceptions.UserRoleMisMatchException;
import com.project.ShopVibes.model.UserDtls;
import com.project.ShopVibes.repository.ProductRepository;
import com.project.ShopVibes.repository.UserRepository;
import com.project.ShopVibes.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/")
	public String home() {
		return "admin/home";
	}

	@GetMapping("/userlist")
	public ModelAndView getAllUsers() {
		ModelAndView mav = new ModelAndView("admin/userlist");
		mav.addObject("user", userRepository.findAll());
		return mav;
	}
	
	@GetMapping("/listofproducts")
	public ModelAndView getAllCategories() {
		ModelAndView mav = new ModelAndView("admin/listofproducts");
		mav.addObject("products", productRepository.findAll());
		return mav;
	}
	
	
	@GetMapping("/changePassword")
	public String loadChangePassword() {
		return "admin/change_password";
	}

	//will get user details by using principal 
	
	@PostMapping("/updatePassword")
	public String changePassword(Principal p, @RequestParam("oldPassword") String oldPassword, 
	                             @RequestParam("newPassword") String newPassword,
	                             HttpSession session) {
	    String email = p.getName();
	    UserDtls loginUser = userRepository.findByEmail(email);
	    
	    // Check if the entered old password matches the user's current password
	    if (passwordEncoder.matches(oldPassword, loginUser.getPassword())) {
	        // If the old password is correct, update the user's password
	        loginUser.setPassword(passwordEncoder.encode(newPassword));
	        UserDtls updatedUser = userRepository.save(loginUser);
	        if (updatedUser != null) {
	            session.setAttribute("msg", "Password changed successfully.");
	            return "redirect:/admin/";
	        } 
	    } else {
	        // If the old password is incorrect, display an error message
	        session.setAttribute("msg", "Incorrect old password.");
	    }
	
	    return "redirect:/admin/changePassword";
	}

	
	@GetMapping("/{id}")
	public String deleteUser(@PathVariable int id, String str) {
	    try {
	        UserDtls user = userService.getUserById(id);
	        if(user.getRole().equalsIgnoreCase("ROLE_USER")) {
	            userService.deleteUserById(id);
	        } else {
	        	str="User role is not ROLE_USER for id";
	            throw new UserRoleMisMatchException(str + id);
	        }
	        return "redirect:/admin/userlist";
	    } catch(NumberFormatException e) {
	        return "redirect:/admin/exception-page";
	    } catch(UserRoleMisMatchException e) {
	        return "redirect:/admin/exception-page";
	    } catch(Exception e) {
	        return "redirect:/admin/exception-page";
	    }
	}

	@GetMapping("/exception-page")
	public String exception() {
		return "admin/exception-page";
	}
}
