package com.example.projectmanagementtask.dao;

import java.util.List;

import com.example.demo.entity.User;
import com.example.projectmanagementtask.entity.Task;



public interface TaskDao {
	

	public void save (Task task);
	
	public List<Task> findAll();
	
	public void delete(int id);
	
	public Task findById(int id);

	List<Task> findByProjectId(int id);

	List<User> findAllTeamLeader();


}
