package com.example.projectv1.service;

import java.util.List;
import java.util.Optional;

import com.example.projectv1.entity.Task;



public interface TaskService {
	
	public List<Task> findAll();
	
	public Optional<Task> findById(int id);
	
	public Task save(Task task);
	
	public void delete(int id);
	

}
