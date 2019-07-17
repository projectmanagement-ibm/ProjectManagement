package com.example.projectv1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

//	
	@RequestMapping("/list")
	public String list(Model theModel) {
		theModel.addAttribute("userList", userService.findAll());
		return "user-list";
//		
	}

	@RequestMapping("/add")
	public String add(Model theModel) {
		User user = new User();
		theModel.addAttribute("user", user);
		return "user-form";
	}

	@RequestMapping("/update")
	public String update(@RequestParam("id") int id, Model theModel) {
		User user = userService.findById(id);
		theModel.addAttribute("user", user);
		return "user-form";
	}

	@RequestMapping("/save")
	public String save(@ModelAttribute("user") User user) {

		userService.save(user);
		return "redirect:/users/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		userService.delete(id);
		return "redirect:/users/list";
	}
	
	
	@GetMapping("/search")
	public String search(@RequestParam("firstName") String theFirstName,
						 Model theModel) {
		
		// check names, if both are empty then just give list of all employees

		if (theFirstName.trim().isEmpty()) {
			return "redirect:/employees/list";
		}
		else {
			// else, search by first name and last name
			List<User> userList =
							userService.findByFirstName(theFirstName);
			
			// add to the spring model
			theModel.addAttribute("userList", userList);
			
			// send to list-employees
			return "user-list";
		}
		
	}
}
