package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;


@Repository
public class ProjectDAOImpl implements ProjectDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<User> findAllManager() {
		Session session = entityManager.unwrap(Session.class);
		String select = "SELECT ua FROM User ua WHERE ua.roleId=:roleId";
		List<User> users = null;
		Query query = entityManager.createQuery(select);
		query.setParameter("roleId", 1);

		try {

			users = query.getResultList();
		} catch (Exception e) {
			return null;
		}
		return users;
	}

}
