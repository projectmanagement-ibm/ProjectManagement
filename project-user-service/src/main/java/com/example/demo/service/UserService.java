package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;

public interface UserService {


	public void save (User user);
	
	public List<User> findAll();
	
	public void delete(int id);
	
	public User findById(int id);
	
	public List<User> findByFirstName(String fName);

	List<Role> findAllRole();


    //public List<User> searchByName(String theFirstName, String theLastName);

}
