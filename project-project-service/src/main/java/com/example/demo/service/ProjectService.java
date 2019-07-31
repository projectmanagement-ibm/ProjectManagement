
package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Project;
import com.example.demo.entity.User;


public interface ProjectService {

	public List<Project> findAll();

	public Project save(Project project);

	public void deleteById(int id);

	public Optional<Project> findById(int id);

	public List<Project> searchBy(String theName);

	public List<User> findAllManager();

}
