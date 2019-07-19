package com.example.projectv1.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.projectv1.entity.User;
import com.example.projectv1.entity.UserAccount;
import com.example.projectv1.entity.Users;
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

		Users userAccount = new Users();
		theModel.addAttribute("userAccount", userAccount);

		return "login";
	}

	@RequestMapping("/loginProcess")
	public String Log(@Valid @ModelAttribute("userAccount") UserAccount userAccount, BindingResult bindingResult) {

//		User user = new User();
		ModelAndView modelAndView = new ModelAndView();

		UserAccount userExists = loginService.login(userAccount);

		if (userExists == null) {
			bindingResult.rejectValue("username", "error.user", "There is no such user");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
			return "login";
		}
		return "dashboard";

//		return "dashboard";
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
