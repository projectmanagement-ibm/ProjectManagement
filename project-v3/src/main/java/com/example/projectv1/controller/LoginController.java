package com.example.projectv1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectv1.entity.User;
import com.example.projectv1.entity.UserAccount;
import com.example.projectv1.service.LoginService;

@Controller

public class LoginController {

	private LoginService loginService;

	@Autowired
	public LoginController(LoginService loginService) {
		super();
		this.loginService = loginService;
	}

	public LoginController() {
		super();
	}

	@RequestMapping("/login")
	public String home(Model theModel) {

		UserAccount userAccount = new UserAccount();
		theModel.addAttribute("userAccount", userAccount);
		return "login";
	}

	@RequestMapping("/loginProcess")
	public String log(@ModelAttribute("userAccount") UserAccount userAccount) {

//		User user = new User();
		UserAccount theUser = loginService.login(userAccount);

		return "dashboard";
//		theModel.addAttribute("user", user);
//		if(theUser == null ) {
//			throw new UserNotFoundException("Invalid User");
//		} 
//		
//		Response response = new Response();
//		response.setStatus(HttpStatus.OK.value());
//		response.setMessage("Logged in successfully");
//		response.setTime(System.currentTimeMillis());

	}
}
