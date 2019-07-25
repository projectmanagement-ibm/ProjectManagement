package com.example.projectv1.service;

import java.util.List;
import java.util.Optional;

import com.example.projectv1.entity.Task;
import com.example.projectv1.entity.User;



public interface TaskService {
	
	public List<Task> findAll();
	
	public Task findById(int id);
	
	public void save(Task task);
	
	public void delete(int id);
	
	List<Task> findByProjectId(int id);
	
	List<User> findAllTeamLeader();


}
