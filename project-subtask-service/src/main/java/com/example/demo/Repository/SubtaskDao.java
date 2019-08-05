package com.example.demo.Repository;

import java.util.List;

import com.example.demo.entity.SubTask;
import com.example.demo.entity.UserAccount;

public interface SubtaskDao {

	List<UserAccount> findAllDeveloper();

	SubTask findById(int id);

	List<SubTask> findByTaskId(int id);

	List<SubTask> findSubTaskByUserId(int id);

}
