package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Project;
import com.example.demo.entity.User;
import com.example.demo.entity.UserAccount;


public interface ProjectDAO {

	public List<UserAccount> findAllManager() ;
	
	public List<Project> findProjectByUserId(int id);

}
