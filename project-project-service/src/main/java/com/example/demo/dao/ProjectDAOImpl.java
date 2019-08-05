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

import com.example.demo.entity.Project;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.entity.UserAccount;


@Repository
public class ProjectDAOImpl implements ProjectDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<UserAccount> findAllManager() {
		
		List<UserAccount> users = null;
		Role manager = null;
		Session session = entityManager.unwrap(Session.class);
		
		String selectManager  = "select manager FROM Role manager WHERE manager.roleName=:roleName";
		Query query1 = entityManager.createQuery(selectManager);
		query1.setParameter("roleName", "manager");
		manager = (Role) query1.getSingleResult();
		System.out.println("manager=================" + manager.getRoleId());
		
		String select = "SELECT ua FROM UserAccount ua WHERE ua.roleId=:roleId";
		
		Query query = entityManager.createQuery(select);
		query.setParameter("roleId", manager.getRoleId());

		try {

			users = query.getResultList();
			
		} catch (Exception e) {
			System.out.println("error======" + e);
			return null;
		}
		return users;
	}

	@Override
	public List<Project> findProjectByUserId(int id) {
		// TODO Auto-generated method stub
		List<Project> projects = null; 
		Session session = entityManager.unwrap(Session.class);
		
		String select  = "select projects FROM Project projects WHERE projects.userId=:userId";
		Query query = entityManager.createQuery(select);
		query.setParameter("userId", id);
		try {

			projects = query.getResultList();
			
		} catch (Exception e) {
			System.out.println("error======" + e);
			return null;
		}
		return projects;
	}
}
