package com.example.projectv1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectv1.dao.ProjectRepositoryDAO;
import com.example.projectv1.entity.Project;



@Service
public class ProjectServiceImpl implements ProjectService {
	
	private ProjectRepositoryDAO projectRepositoryDAO;
	
	@Autowired
	public ProjectServiceImpl(ProjectRepositoryDAO projectRepositoryDAO) {
		super();
		this.projectRepositoryDAO = projectRepositoryDAO;
	}

	@Override
	public List<Project> findAll() {
		// TODO Auto-generated method stub
		return projectRepositoryDAO.findAll();
	}

	@Override
	public Project save(Project project) {
		// TODO Auto-generated method stub
		return projectRepositoryDAO.save(project);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		projectRepositoryDAO.deleteById(id);
	}

	@Override
	public Optional<Project> findById(int id) {
		// TODO Auto-generated method stub
		return projectRepositoryDAO.findById(id);
	}

	@Override
	public List<Project> searchBy(String theName) {
		// TODO Auto-generated method stub
		return projectRepositoryDAO.findByNameContainsAllIgnoreCase(theName);	
	}

}
