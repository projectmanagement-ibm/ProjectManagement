package com.example.projectv1.dao;

import java.util.List;

import com.example.projectv1.entity.User;

public interface UserDAO {

	
	public void save (User user);
	
	public List<User> findAll();
	
	public void delete(int id);
	
	public User findById(int id);

	public List<User> findByFirstName(String fName);
}
