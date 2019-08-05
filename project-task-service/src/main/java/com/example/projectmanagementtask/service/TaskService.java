package com.example.projectmanagementtask.service;

import java.util.List;

import com.example.projectmanagementtask.entity.Task;
import com.example.projectmanagementtask.entity.UserAccount;


public interface TaskService {
	
public List<Task> findAll();
	
	public Task findById(int id);
	
	public void save(Task task);
	
	public void delete(int id);
	
	List<Task> findByProjectId(int id);
	
	List<UserAccount> findAllTeamLeader();
	List<Task> findTaskByUserId(int id);


}
