package com.example.projectv1.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectv1.dao.TaskDAO;
import com.example.projectv1.entity.Task;
import com.example.projectv1.entity.User;

@Service
public class TaskServiceImpl implements TaskService {

	private TaskDAO taskDAO;

	@Autowired
	public TaskServiceImpl(TaskDAO taskDAO) {
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

	

}
