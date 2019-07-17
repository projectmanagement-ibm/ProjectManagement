package com.example.projectv1.dao;

import java.util.List;

import com.example.projectv1.entity.Task;
import com.example.projectv1.entity.User;

public interface TaskDAO {

	public void save (Task task);
	
	public List<Task> findAll();
	
	public void delete(int id);
	
	public Task findById(int id);

}
