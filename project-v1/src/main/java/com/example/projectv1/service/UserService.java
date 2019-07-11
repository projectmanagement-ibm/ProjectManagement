package com.example.projectv1.service;

import java.util.List;

import com.example.projectv1.entity.User;

public interface UserService {

	List<User > findAll();
	
	void save(User user);

}
