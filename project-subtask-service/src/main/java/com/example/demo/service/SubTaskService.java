package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.SubTask;
import com.example.demo.entity.UserAccount;

public interface SubTaskService {

	public SubTask createSubTask(SubTask subTask);
	public List<SubTask> getAllSubTask();
	public Optional<SubTask> getById(int id);
	public void deleteById(int id);
	
	List<UserAccount> findAllDeveloper();

	SubTask findById(int id);

	List<SubTask> findByTaskId(int id);

	List<SubTask> findSubTaskByUserId(int id);
	
	
}
