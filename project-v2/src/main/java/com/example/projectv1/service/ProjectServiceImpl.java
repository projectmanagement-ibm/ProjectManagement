package com.example.projectv1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectv1.dao.ProjectDAOImpl;
import com.example.projectv1.dao.ProjectRepositoryDAO;
import com.example.projectv1.entity.Project;
import com.example.projectv1.entity.User;



@Service
public class ProjectServiceImpl implements ProjectService {
	
	private ProjectRepositoryDAO projectRepositoryDAO;
	private ProjectDAOImpl projectDAOImpl;
	
	@Autowired
	public ProjectServiceImpl(ProjectRepositoryDAO projectRepositoryDAO, ProjectDAOImpl projectDAOImpl) {
		super();
		this.projectRepositoryDAO = projectRepositoryDAO;
		this.projectDAOImpl = projectDAOImpl;
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

	@Override
	public List<User> findAllManager() {
		// TODO Auto-generated method stub
		return projectDAOImpl.findAllManager();
	}

}

