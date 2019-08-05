package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProjectDAOImpl;
import com.example.demo.dao.ProjectRepositoryDAO;
import com.example.demo.entity.Project;
import com.example.demo.entity.User;
import com.example.demo.entity.UserAccount;

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
	public Project findById(int id) {
		// TODO Auto-generated method stub
		return projectRepositoryDAO.findById(id).get();
	}

	@Override
	public List<Project> searchBy(String theName) {
		// TODO Auto-generated method stub
		return projectRepositoryDAO.findByNameContainsAllIgnoreCase(theName);	
	}

	@Override
	public List<UserAccount> findAllManager() {
		// TODO Auto-generated method stub
		return projectDAOImpl.findAllManager();
	}

	@Override
	public List<Project> findProjectByUserId(int id) {
		// TODO Auto-generated method stub
		return projectDAOImpl.findProjectByUserId(id);
		
	}

}

