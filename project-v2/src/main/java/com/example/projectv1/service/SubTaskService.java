package com.example.projectv1.service;

import java.util.List;

import com.example.projectv1.entity.SubTask;
import com.example.projectv1.entity.User;



public interface SubTaskService {
	
public List<SubTask> findAll();
	
	public SubTask findById(int id);
	
	public void save(SubTask subTask);
	
	public void delete(int id);
	
	List<SubTask> findByTaskId(int id);

	List<User> findAllDeveloper();
	
}
