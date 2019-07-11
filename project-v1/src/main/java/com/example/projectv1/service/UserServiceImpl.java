package com.example.projectv1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectv1.dao.UserRepositoryDAO;
import com.example.projectv1.entity.User;

@Service
public class UserServiceImpl implements UserService {

	private UserRepositoryDAO userRepositoryDAO;
	
	@Autowired
	public UserServiceImpl(UserRepositoryDAO userRepositoryDAO) {
		super();
		this.userRepositoryDAO = userRepositoryDAO;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepositoryDAO.findAll();
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userRepositoryDAO.save(user);
	}

}
