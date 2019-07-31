package com.example.projectmanagementtask.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;
import com.example.projectmanagementtask.entity.Task;

@Repository
public class TaskDaoImpl implements TaskDao {
	
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public void save(Task task) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(task);

	}

	@Override
	public List<Task> findAll() {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		TypedQuery<Task> query = session.createQuery("from Task", Task.class);
		return query.getResultList();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		Task task = session.get(Task.class, id);
		session.delete(task);

	}

	@Override
	public Task findById(int id) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		Task task = session.get(Task.class, id);
		return task;
	}
	
	@Override
	public List<Task> findByProjectId(int id) {
		Session session = entityManager.unwrap(Session.class);

		List <Task> taskList = null;
		String select = "SELECT task FROM Task task WHERE task.projectId=:projectId";
		Query query = entityManager.createQuery(select);
		query.setParameter("projectId", id);

		try {

			taskList = query.getResultList();
		} catch (Exception e) {
			return null;
		}
		return taskList;
		
	}
	
	
	
	@Override
	public List<User> findAllTeamLeader() {
		Session session = entityManager.unwrap(Session.class);
		String select = "SELECT ua FROM User ua WHERE ua.roleId=:roleId";
		List<User> users = null;
		Query query = entityManager.createQuery(select);
		query.setParameter("roleId", 2);

		try {

			users = query.getResultList();
		} catch (Exception e) {
			return null;
		}
		return users;
	}

}
