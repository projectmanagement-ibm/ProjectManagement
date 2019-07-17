package com.example.projectv1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectv1.dao.TaskDaoRepository;
import com.example.projectv1.entity.Task;

@Service
public class TaskServiceImpl implements TaskService {

	private TaskDaoRepository taskDaoRepository;

	@Autowired
	public TaskServiceImpl(TaskDaoRepository taskDaoRepository) {
		super();
		this.taskDaoRepository = taskDaoRepository;
	}

	@Override
	public List<Task> findAll() {
		// TODO Auto-generated method stub
		return taskDaoRepository.findAll();
	}

	@Override
	public Optional<Task> findById(int id) {
		// TODO Auto-generated method stub

		return taskDaoRepository.findById(id);
	}

	@Override
	public Task save(Task task) {
		// TODO Auto-generated method stub
		return taskDaoRepository.save(task);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		taskDaoRepository.deleteById(id);
	}

}
