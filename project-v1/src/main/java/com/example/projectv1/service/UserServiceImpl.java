package com.example.projectv1.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectv1.dao.UserDAO;
import com.example.projectv1.entity.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;


	@Autowired
	public UserServiceImpl(UserDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}
//
//	@Override
//	public List<User> findAll() {
//		// TODO Auto-generated method stub
//		return userRepositoryDAO.findAll();
//	}

	@Override
	@Transactional
	public void save(User user) {
		// TODO Auto-generated method stub
		userDAO.save(user);
	}

//	@Override
//	public void delete(int id) {
//		// TODO Auto-generated method stub
//		userRepositoryDAO.deleteById(id);
//	}
//
//	@Override
//	public User findById(int id) {
//		// TODO Auto-generated method stub
//		Optional<User> tempUser = userRepositoryDAO.findById(id);
//		User user = tempUser.get();
//		
//		return user;
//	}
//
//	@Override
//	public List<User> searchByName(String theFirstName, String theLastName) {
//		
//		return userRepositoryDAO.
//				findByFirstNameContainsAndLastNameContainsAllIgnoreCase(
//						theFirstName, theLastName);	
//	}
	
}
