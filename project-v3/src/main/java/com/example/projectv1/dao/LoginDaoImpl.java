package com.example.projectv1.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projectv1.entity.UserAccount;

@Repository
public class LoginDaoImpl implements LoginDao {

	private EntityManager entityManager;

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
		String select = "SELECT ua FROM UserAccount ua WHERE ua.username=:username and ua.password=:password";

		Query query = entityManager.createQuery(select);
		query.setParameter("username", userAccount.getUsername());
		query.setParameter("password", userAccount.getPassword());

		try {
			theUser = (UserAccount) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}

		return theUser;
	}

}
