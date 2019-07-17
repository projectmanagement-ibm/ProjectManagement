package com.example.projectv1.service;

import java.util.List;
import java.util.Optional;

import com.example.projectv1.entity.Project;



public interface ProjectService {
	
public List<Project> findAll();
	
	public Project save(Project project);
	
	public void deleteById(int id);
	
	public Optional<Project> findById(int id);
	
	public List<Project> searchBy(String theName);

}
