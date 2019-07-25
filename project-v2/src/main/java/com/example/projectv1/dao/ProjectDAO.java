package com.example.projectv1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectv1.entity.User;

public interface ProjectDAO {

	public List<User> findAllManager() ;

}
