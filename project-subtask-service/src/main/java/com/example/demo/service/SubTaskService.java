package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.SubTask;

public interface SubTaskService {

	public SubTask createSubTask(SubTask subTask);
	public List<SubTask> getAllSubTask();
	public Optional<SubTask> getById(int id);
	public void deleteById(int id);
	
	
	
}
