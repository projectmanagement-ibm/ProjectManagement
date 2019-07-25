package com.example.projectv1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectv1.dao.SubTaskDao;
import com.example.projectv1.entity.SubTask;
import com.example.projectv1.entity.User;
@Service
public class SubTaskServiceImpl implements SubTaskService {

	
	private SubTaskDao subTaskDao;
	
	@Autowired
	public SubTaskServiceImpl(SubTaskDao subTaskDao) {
		super();
		this.subTaskDao = subTaskDao;
	}

	@Override
	public List<SubTask> findAll() {
		// TODO Auto-generated method stub
		return subTaskDao.findAll();
	}

	@Override
	public SubTask findById(int id) {
		// TODO Auto-generated method stub
		return subTaskDao.findById(id);
	}

	@Override
	public void save(SubTask subTask) {
		// TODO Auto-generated method stub
		subTaskDao.save(subTask);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		subTaskDao.delete(id);
	}

	@Override
	public List<SubTask> findByTaskId(int id) {
		// TODO Auto-generated method stub
		return subTaskDao.findByTaskId(id);
	}

	@Override
	public List<User> findAllDeveloper() {
		// TODO Auto-generated method stub
		return subTaskDao.findAllDeveloper();
	}

}
