package com.example.demo.dao;


import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Project;



public interface ProjectRepositoryDAO extends JpaRepository<Project,Integer> {
	
	
	public List<Project> findByNameContainsAllIgnoreCase(String theName);
}
