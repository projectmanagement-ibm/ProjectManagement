package com.example.projectmanagementtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProjectManagementTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementTaskApplication.class, args);
	}

}
