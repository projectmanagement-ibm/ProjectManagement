package com.example.projectv1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projectv1.entity.Role;
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

		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(user);
		
		Query query = session.createQuery("from User order by id DESC");
		query.setMaxResults(1);
		User lastUser = (User) query.getSingleResult();
		System.out.println("last" + lastUser.getId());
		System.out.print("roleId=======" + user.getRoleId());
		
		UserAccount userAccount  = new UserAccount();
		userAccount.setUsername(user.getFirstName()+"@ibm");
		userAccount.setPassword(user.getFirstName()+"@123");
		userAccount.setUserId(lastUser.getId());
		userAccount.setRoleId(user.getRoleId());
		session.save(userAccount);
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
	
	@Override 
	public List<Role> findAllRole() {
		Session session = entityManager.unwrap(Session.class);
		TypedQuery<Role> query = session.createQuery("from Role", Role.class);

		return query.getResultList();
	}

}