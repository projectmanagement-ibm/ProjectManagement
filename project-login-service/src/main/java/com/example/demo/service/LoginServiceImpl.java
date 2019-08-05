package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LoginDao;
import com.example.demo.entity.UserAccount;



@Service
public class LoginServiceImpl implements LoginService {

	private LoginDao loginDao;
	@Autowired
	public LoginServiceImpl(LoginDao loginDao) {
		super();
		this.loginDao = loginDao;
	}
	
	public LoginServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	@Transactional
	public UserAccount login(UserAccount userAccount) {
		// TODO Auto-generated method stub
		return loginDao.login(userAccount);
	}

}
