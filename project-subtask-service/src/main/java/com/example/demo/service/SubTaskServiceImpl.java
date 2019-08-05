package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.SubTaskRepo;
import com.example.demo.Repository.SubtaskDao;
import com.example.demo.entity.SubTask;
import com.example.demo.entity.UserAccount;

@Service
public class SubTaskServiceImpl implements SubTaskService {

	private SubTaskRepo repo;
	private SubtaskDao subTaskDao;

	@Autowired
	public SubTaskServiceImpl(SubTaskRepo repo, SubtaskDao subTaskDao) {
		super();
		this.repo = repo;
		this.subTaskDao = subTaskDao;
	}

	@Override
	public SubTask createSubTask(SubTask subTask) {

		return repo.save(subTask);

	}

	@Override
	public List<SubTask> getAllSubTask() {

		return repo.findAll();
	}

	@Override
	public Optional<SubTask> getById(int id) {

		Optional<SubTask> subTask = repo.findById(id);

		return subTask;
	}

	@Override
	public void deleteById(int id) {
		repo.deleteById(id);

	}

	@Override
	public List<UserAccount> findAllDeveloper() {
		// TODO Auto-generated method stub
		return subTaskDao.findAllDeveloper();
	}

	@Override
	public SubTask findById(int id) {
		// TODO Auto-generated method stub
		return subTaskDao.findById(id);
	}

	@Override
	public List<SubTask> findByTaskId(int id) {
		// TODO Auto-generated method stub
		return subTaskDao.findByTaskId(id);
	}

	@Override
	public List<SubTask> findSubTaskByUserId(int id) {
		// TODO Auto-generated method stub
		return subTaskDao.findSubTaskByUserId(id);
	}

}
