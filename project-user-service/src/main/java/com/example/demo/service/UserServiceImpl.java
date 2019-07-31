package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.management.relation.Role;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDAO;
import com.example.demo.entity.User;


@Service
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;


	@Autowired
	public UserServiceImpl(UserDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}

	@Override
	@Transactional
	public void save(User user) {
		// TODO Auto-generated method stub
		userDAO.save(user);
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		userDAO.delete(id);
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		
		return userDAO.findById(id);
	}
//
//	@Override
//	public List<User> searchByName(String theFirstName, String theLastName) {
//		
//		return userRepositoryDAO.
//				findByFirstNameContainsAndLastNameContainsAllIgnoreCase(
//						theFirstName, theLastName);	
//	}

	@Override
	public List<User> findByFirstName(String fName) {
		// TODO Auto-generated method stub
		return userDAO.findByFirstName(fName);
	}

	@Override
	@Transactional
	public List<Role> findAllRole() {
		// TODO Auto-generated method stub
		return userDAO.findAllRole();
	}
	
}
