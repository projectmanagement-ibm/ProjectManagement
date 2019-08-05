package com.example.projectmanagementtask.dao;

import java.util.List;


import com.example.projectmanagementtask.entity.Task;
import com.example.projectmanagementtask.entity.UserAccount;



public interface TaskDao {
	

	public void save (Task task);
	
	public List<Task> findAll();
	
	public void delete(int id);
	
	public Task findById(int id);

	List<Task> findByProjectId(int id);

	List<UserAccount> findAllTeamLeader();

	List<Task> findTaskByUserId(int id);


}
