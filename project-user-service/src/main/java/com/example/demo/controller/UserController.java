package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	
	@GetMapping("/users")
	public List<User> list() {
		return  userService.findAll();
	
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id) {
		return  userService.findById(id);
	}

	@PostMapping("/users")
	public String save(@RequestBody User user) {

		userService.save(user);
		return "user added successfully";
	}
	
	@PutMapping("/users")
	public String update(@RequestBody User user) {
		userService.save(user);
		return "user updated successfully";
	}

	@DeleteMapping("/users/{id}")
	public String delete(@PathVariable int id) {
		userService.delete(id);
		return "user deleted successfully";
	}
	
	
	@GetMapping("/users/roles")
	public List<Role> findAllRoles(){
		return this.userService.findAllRole();
	}
	
	@GetMapping("/users/search/{theFirstName}")
	public List<User> search(@PathVariable String theFirstName) {
		
			List<User> userList = userService.findByFirstName(theFirstName);
			
			// send to list-employees
			return userList;
		}
		
	}

