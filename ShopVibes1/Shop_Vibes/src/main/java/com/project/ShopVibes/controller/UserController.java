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
import org.springframework.web.servlet.ModelAndView;

import com.project.ShopVibes.exceptions.EmailAlreadyExistsException;
import com.project.ShopVibes.model.UserDtls;
import com.project.ShopVibes.repository.AddressRepository;
import com.project.ShopVibes.repository.CartItemRepository;
import com.project.ShopVibes.repository.ProductRepository;
import com.project.ShopVibes.repository.UserRepository;
import com.project.ShopVibes.service.UserService;

@Controller
@RequestMapping("/cust")
public class UserController {

	@Autowired
	private ProductRepository productRepository;
		
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private AddressRepository addressRepository;
	//principal will create an user object
	
	@ModelAttribute
	private void userDetails(Model m, Principal p) {
		String email = p.getName();
		UserDtls user = userRepo.findByEmail(email);

		m.addAttribute("user", user);

	}

	
//	@GetMapping("/")
//	public String home() {
//		return "user/home";
//	}

	
	@GetMapping("/")
	public ModelAndView getAllCategories() {
		ModelAndView mav = new ModelAndView("user/listofproducts");
		mav.addObject("products", productRepository.findAll());
		return mav;
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
				return "redirect:/cust/";
			}else {
				session.setAttribute("msg", "Something went wrong");

			}
			
		}else {
			session.setAttribute("msg", "Old Password is incorrect");
			return "redirect:/cust/changePassword";
		}
		
		return "redirect:/cust/changePassword";
	}
	
	
	@GetMapping("/edit/{id}")
	public String editUserForm(@PathVariable int id, Model model) {
		model.addAttribute("user",userService.getUserById(id));
		return "user/edituser";
	}
	
	@PostMapping("/edit/{id}")
	public String updateuser(@PathVariable int id, @ModelAttribute("user") UserDtls user, Model model) {
	    // Get user from db
	    UserDtls existinguser = userService.getUserById(id);
	    
	    // Check if the email already exists in the database
	    UserDtls userWithSameEmail = userRepo.findByEmail(user.getEmail());
	    if (userWithSameEmail != null && userWithSameEmail.getId() != id) {
	        throw new RuntimeException("Email ID already exists");
	    }
	    
	    // Update the user's details
	    existinguser.setFirstName(user.getFirstName());
	    existinguser.setLastName(user.getLastName());
	    existinguser.setEmail(user.getEmail());
	    existinguser.setPassword(passwordEncoder.encode(user.getPassword()));
	    
	    userService.editUser(existinguser);
	    return "redirect:/signin";
	}

	
//	@PostMapping("/edit/{id}")
//	public String updateuser(@PathVariable int id, @ModelAttribute("user") UserDtls user, Model model) {
//	    // Get user from db
//	    UserDtls existinguser = userService.getUserById(id);
//
//	    // Check if the email already exists in the database
//	    UserDtls userWithSameEmail = userRepo.findByEmail(user.getEmail());
//	    if (userWithSameEmail != null && userWithSameEmail.getId() != id) {
//	        model.addAttribute("errorMessage", "Email ID already exists");
//	        return "user/edituser";
//	    }
//
//	    // Update the user's details
//	    existinguser.setFirstName(user.getFirstName());
//	    existinguser.setLastName(user.getLastName());
//	    existinguser.setEmail(user.getEmail());
//	    existinguser.setPassword(passwordEncoder.encode(user.getPassword()));
//
//	    userService.editUser(existinguser);
//	    return "redirect:/shopvibes/signin";
//	}

	
	
//	@GetMapping("/listofproducts")
//	public ModelAndView getAllCategories() {
//		ModelAndView mav = new ModelAndView("user/listofproducts");
//		mav.addObject("products", productRepository.findAll());
//		return mav;
//	}
//	
	@GetMapping("/addtocart")
	public ModelAndView addToCart() {
		ModelAndView mav = new ModelAndView("user/addtocart");
		//mav.addObject("cart", productRepository.findAll());
		mav.addObject("cart", cartItemRepository.findAll());
		return mav;
	}
	
	
//	@GetMapping("/addtocheckout")
//	public ModelAndView addToCheckout() {
//		ModelAndView mav = new ModelAndView("user/checkout");
//		//mav.addObject("cart", productRepository.findAll());
//		mav.addObject("checkout", cartItemRepository.findAll());
//		return mav;
//	}
}
