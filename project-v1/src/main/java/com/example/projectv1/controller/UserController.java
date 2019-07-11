package com.example.projectv1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.projectv1.entity.User;
import com.example.projectv1.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	private UserService userService;
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@RequestMapping("/list")
	public String list(Model theModel) {
		theModel.addAttribute("userList", userService.findAll());
		return "user-list";
		
	}
	
	@RequestMapping("/add")
	public String add(Model theModel) {
		User user = new User();
		theModel.addAttribute("user", user);
		return "user-form";
	}
	
	@RequestMapping("/save")
	public String save(@ModelAttribute("user") User user) {
		
		userService.save(user);
		return "redirect:/users/list";
	}
	

}
