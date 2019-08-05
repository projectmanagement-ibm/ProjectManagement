package com.example.projectmanagementtask.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectmanagementtask.dao.TaskDao;
import com.example.projectmanagementtask.entity.Task;
import com.example.projectmanagementtask.entity.UserAccount;


@Service
public class TaskServiceImpl implements TaskService{
	
	private TaskDao taskDAO;
	
	@Autowired
	public TaskServiceImpl(TaskDao taskDAO) {
		super();
		this.taskDAO = taskDAO;
	}

	@Override
	@Transactional
	public List<Task> findAll() {
		// TODO Auto-generated method stub
		return taskDAO.findAll();
	}

	@Override
	@Transactional
	public Task findById(int id) {
		// TODO Auto-generated method stub

		return taskDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Task task) {
		// TODO Auto-generated method stub
	     taskDAO.save(task);
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		taskDAO.delete(id);
	}

	@Override
	public List<Task> findByProjectId(int id) {
		// TODO Auto-generated method stub
		return taskDAO.findByProjectId(id);
	}

	@Override
	public List<UserAccount> findAllTeamLeader() {
		// TODO Auto-generated method stub
		return taskDAO.findAllTeamLeader();
	}

	@Override
	public List<Task> findTaskByUserId(int id) {
		// TODO Auto-generated method stub
		return taskDAO.findTaskByUserId(id);
	}

}
