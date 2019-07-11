package com.example.projectv1.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projectv1.entity.User;
import com.example.projectv1.entity.UserAccount;

@Repository
public class UserDAOImpl implements UserDAO {

	private EntityManager entityManager;
	@Autowired
	public UserDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		
	
		    entityManager.createNativeQuery("INSERT INTO user_account ( username, password) VALUES (?,?)")
		      .setParameter(1, user.getFirstName()+"@ibm")
		      .setParameter(2, user.getFirstName()+"@123")
		      .executeUpdate();
	
		
		    entityManager.createNativeQuery("INSERT INTO user ( first_name, last_name, contact, email, address) VALUES (?,?, ?, ?, ?)")
		      .setParameter(1, user.getFirstName())
		      .setParameter(2, user.getLastName())
		      .setParameter(3, user.getContact())
		      .setParameter(4, user.getEmail())
		      .setParameter(5, user.getAddress())
		      .executeUpdate();
	
	}
	
}
