package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.SubTaskRepo;
import com.example.demo.entity.SubTask;

@Service
public class SubTaskServiceImpl implements SubTaskService {

	private SubTaskRepo repo;

	@Autowired
	public SubTaskServiceImpl(SubTaskRepo repo) {
		super();
		this.repo = repo;
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

}
