package com.example.projectv1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projectv1.entity.Task;

@Repository
public class TaskDAOImpl implements TaskDAO {

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

}
