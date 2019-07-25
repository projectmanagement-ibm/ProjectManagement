package com.example.projectv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// exclude the spring auto configuration
@SpringBootApplication()


public class ProjectV1Application {

	public static void main(String[] args) {
		SpringApplication.run(ProjectV1Application.class, args);
	}

}
