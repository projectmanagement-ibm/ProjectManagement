package com.example.projectv1.dao;

import java.util.List;

import com.example.projectv1.entity.SubTask;
import com.example.projectv1.entity.User;



public interface SubTaskDao {
	
public void save (SubTask subTask);
	
	public List<SubTask> findAll();
	
	public void delete(int id);
	
	public SubTask findById(int id);

	List<SubTask> findByTaskId(int id);

	List<User> findAllDeveloper();


}
