package com.example.projectv1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projectv1.entity.SubTask;
import com.example.projectv1.entity.Task;
import com.example.projectv1.entity.User;

@Repository
public class SubTaskDaoImpl implements SubTaskDao {

	private EntityManager entityManager;

	@Autowired
	public SubTaskDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public void save(SubTask subTask) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(subTask);

	}

	@Override
	public List<SubTask> findAll() {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		TypedQuery<SubTask> query = session.createQuery("from SubTask", SubTask.class);
		return query.getResultList();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		SubTask subTask = session.get(SubTask.class, id);
		session.delete(subTask);

	}

	@Override
	public SubTask findById(int id) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		SubTask subTask = session.get(SubTask.class, id);
		return subTask;
	}

	@Override
	public List<SubTask> findByTaskId(int id) {
		Session session = entityManager.unwrap(Session.class);

		List<SubTask> subtaskList = null;
		String select = "SELECT subtask FROM SubTask subtask WHERE subtask.taskId=:taskId";
		Query query = entityManager.createQuery(select);
		query.setParameter("taskId", id);

		try {

			subtaskList = query.getResultList();
		} catch (Exception e) {
			return null;
		}
		return subtaskList;

	}

	@Override
	public List<User> findAllDeveloper() {
		Session session = entityManager.unwrap(Session.class);
		String select = "SELECT ua FROM User ua WHERE ua.roleId=:roleId";
		List<User> users = null;
		Query query = entityManager.createQuery(select);
		query.setParameter("roleId", 3);

		try {

			users = query.getResultList();
		} catch (Exception e) {
			return null;
		}
		return users;
	}

}
