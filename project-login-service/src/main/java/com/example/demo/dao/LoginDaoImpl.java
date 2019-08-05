package com.example.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserAccount;


@Repository
public class LoginDaoImpl implements LoginDao {

	private EntityManager entityManager;
	
//	@Autowired
//	BCryptPasswordEncoder encoder;

	@Autowired
	public LoginDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	public LoginDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserAccount login(UserAccount userAccount) {
		// TODO Auto-generated method stub
		UserAccount theUser = null;
//		String select = "SELECT ua FROM UserAccount ua WHERE ua.username=:username and ua.password=:password";
		String select = "SELECT ua FROM UserAccount ua WHERE ua.username=:username";

		Query query = entityManager.createQuery(select);
		query.setParameter("username", userAccount.getUsername());
//		query.setParameter("password", userAccount.getPassword());

		try {

			theUser = (UserAccount) query.getSingleResult();
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
			
			if(!encoder.matches(userAccount.getPassword(), theUser.getPassword())) {
                return 	null;			
			}
		} catch (Exception e) {
			return null;
		}

		return theUser;
	}

}
