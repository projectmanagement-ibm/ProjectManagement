package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;

public interface UserDAO {

	
	public void save (User user);
	
	public List<User> findAll();
	
	public void delete(int id);
	
	public User findById(int id);

	public List<User> findByFirstName(String fName);

	List<Role> findAllRole();
}
