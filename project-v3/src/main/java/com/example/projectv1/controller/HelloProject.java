package com.example.projectv1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class HelloProject {
	
	
		@RequestMapping("hello")
		public String showPage()
		{
			return "project-page";
		}

	}

