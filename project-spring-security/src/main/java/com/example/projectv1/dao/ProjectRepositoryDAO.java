package com.example.projectv1.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectv1.entity.Project;




public interface ProjectRepositoryDAO extends JpaRepository<Project,Integer> {
	
	
	public List<Project> findByNameContainsAllIgnoreCase(String theName);

}
