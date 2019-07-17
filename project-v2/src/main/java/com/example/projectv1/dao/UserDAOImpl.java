package com.example.projectv1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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

//	
//		    entityManager.createNativeQuery("INSERT INTO user_account ( username, password) VALUES (?,?)")
//		      .setParameter(1, user.getFirstName()+"@ibm")
//		      .setParameter(2, user.getFirstName()+"@123")
//		      .executeUpdate();

//		
//		    entityManager.createNativeQuery("INSERT INTO user ( first_name, last_name, contact, email, address) VALUES (?,?, ?, ?, ?)")
//		      .setParameter(1, user.getFirstName())
//		      .setParameter(2, user.getLastName())
//		      .setParameter(3, user.getContact())
//		      .setParameter(4, user.getEmail())
//		      .setParameter(5, user.getAddress())
//		      .executeUpdate();

		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(user);

	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		TypedQuery<User> query = session.createQuery("from User", User.class);

		return query.getResultList();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		User user = session.get(User.class, id);
		session.delete(user);
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub

		Session session = entityManager.unwrap(Session.class);
		User user = session.get(User.class, id);
		return user;
	}

	@Override
	public List<User> findByFirstName(String fName) {
		// TODO Auto-generated method stub

		Session session = entityManager.unwrap(Session.class);

		Query query = entityManager.createQuery("Select a From User a where firstName=:firstName");

		query.setParameter(1, fName);

		return query.getResultList();
		
	}

}
