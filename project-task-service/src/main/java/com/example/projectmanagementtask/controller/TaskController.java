package com.example.projectmanagementtask.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.projectmanagementtask.entity.Task;
import com.example.projectmanagementtask.entity.UserAccount;
import com.example.projectmanagementtask.service.TaskService;


@RestController
@RequestMapping("/api")
public class TaskController {

	private TaskService taskService;

	@Autowired
	public TaskController(TaskService taskservice) {
		super();
		this.taskService = taskservice;
	}

	@GetMapping("/tasks")
	public List<Task> getAllTask() {
		
		 return taskService.findAll();
	}

	@PostMapping("/tasks")
	public String saveTask(@RequestBody Task task ) {

		
		taskService.save(task);
		
		return "Task added";
	}

	@PutMapping("/tasks")
	public String updateTask(@RequestBody Task task) {

		taskService.save(task);
		
		return "Task Updated";
	}

	@DeleteMapping("/tasks/{id}")
	public String deleteTask(@PathVariable int id) {
		taskService.delete(id);
		
		return "Task Deleted";
	}

	@GetMapping("/tasks/{id}")
	public Task findById(@PathVariable int id) {
		return taskService.findById(id);
	}
	
	@GetMapping("/tasks/getTasksByProjectId/{id}")
	public List<Task> findByProjectId(@PathVariable int id) {
		return taskService.findByProjectId(id);

	}
	
	@GetMapping("/tasks/teamLeaders")
	public List<UserAccount> findAllTeamLeaders() {
		return taskService.findAllTeamLeader();
	}
	
	@GetMapping("/tasks/getTasksByUserId/{id}")
	public List<Task> findProjectByUserId(@PathVariable int id) {
		return taskService.findTaskByUserId(id);
	}

}
