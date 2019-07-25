package com.example.projectv1.dao;


import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectv1.entity.Project;
import com.example.projectv1.entity.Role;
import com.example.projectv1.entity.User;




public interface ProjectRepositoryDAO extends JpaRepository<Project,Integer> {
	
	
	public List<Project> findByNameContainsAllIgnoreCase(String theName);
}
