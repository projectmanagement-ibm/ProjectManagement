package com.example.demo.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Role;
import com.example.demo.entity.SubTask;
import com.example.demo.entity.UserAccount;

@Repository
public class SubtaskDaoImpl implements SubtaskDao {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<UserAccount> findAllDeveloper() {
		
		List<UserAccount> users = null;
		Role manager = null;
		Session session = entityManager.unwrap(Session.class);
		
		String selectDeveloper  = "select developer FROM Role developer WHERE developer.roleName=:roleName";
		Query query1 = entityManager.createQuery(selectDeveloper);
		query1.setParameter("roleName", "developer");
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
	public SubTask findById(int id) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		SubTask subTask = session.get(SubTask.class, id);
		return subTask;
	}
	
	@Override
	public List<SubTask> findByTaskId(int id) {
		Session session = entityManager.unwrap(Session.class);

		List <SubTask> subTaskList = null;
		String select = "SELECT subTask FROM SubTask subTask WHERE subTask.taskId=:taskId";
		Query query = entityManager.createQuery(select);
		query.setParameter("taskId",id);     

		try {

			subTaskList = query.getResultList();
		} catch (Exception e) {
			return null;
		}
		return subTaskList;
	}
	
	@Override
	public List<SubTask> findSubTaskByUserId(int id) {
		// TODO Auto-generated method stub
		List<SubTask> subTasks = null; 
		Session session = entityManager.unwrap(Session.class);
		
		String select  = "select subTasks FROM SubTask subTasks WHERE subTasks.userId=:userId";
		Query query = entityManager.createQuery(select);
		query.setParameter("userId", id);
		try {

			subTasks = query.getResultList();
			
		} catch (Exception e) {
			System.out.println("error======" + e);
			return null;
		}
		return subTasks;
	}

}
