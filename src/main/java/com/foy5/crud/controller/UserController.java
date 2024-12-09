package com.foy5.crud.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.foy5.crud.business.abstracts.UserService;
import com.foy5.crud.entities.concretes.User;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class UserController {
	
	private UserService userService;
	
	@GetMapping("/")
	public String listUsers (Model model) {
		
		List<User> user = userService.getAllUsers();
		
		model.addAttribute("user", user);
		
		return "index.html";
		
	}
	
	@GetMapping("/showNewUserForm")
	public String showNewUserForm (Model model) {
		
		User user = new User();
		model.addAttribute("user", user);
		
		return "new_user.html";
	}
	
	@GetMapping("showFormForUpdate/{id}")
	public String showFormForUpdate (@PathVariable (value = "id") int id, Model model) {
		
		User user = userService.getUserById(id);
		
		model.addAttribute("user", user);
		return "update_user.html";
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser (@PathVariable (value = "id") int id) {
		
		this.userService.deleteUser(id);
		
		return "redirect:/";
	}
	
	@PostMapping("/saveUser")
	public String saveUser (@ModelAttribute("user") User user) {
		
		userService.addUser(user);
		
		return "redirect:/";
	}
	
	

}
