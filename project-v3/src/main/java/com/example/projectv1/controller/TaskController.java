package com.example.projectv1.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.projectv1.entity.Task;
import com.example.projectv1.service.TaskService;


@Controller
@RequestMapping("/tasks") 
public class TaskController {
	
	private TaskService taskService;

	@Autowired
	public TaskController(TaskService taskservice) {
		super();
		this.taskService = taskservice;
	}
	
	
	@GetMapping("/taskList")
	public String getAllTask(Model theModel)
	{
		theModel.addAttribute("taskList", taskService.findAll());
		
		return "task-list";
	}
	
	@RequestMapping("/addTask")
	public String addTask(Model theModel)
	{
		Task task = new Task();
		theModel.addAttribute("task", task);
		return "add-task";
	}
	
	@RequestMapping("/saveTask")
	public String saveTask(@ModelAttribute("task") @Valid Task theTask,
			BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "add-task";
		}
		else {		
	
		taskService.save(theTask);
		}
		
		return "redirect:/tasks/taskList";
	}
	
	@RequestMapping("/updateTask")
	public String updateTask(@RequestParam("id") int id,Model theModel)
	{
		
		Optional<Task> task = taskService.findById(id);
		
		theModel.addAttribute("task", task);
		return "add-task";
	}
	
	@RequestMapping("/deleteTask")
	public String deleteTask(@RequestParam("id") int id)
	{
		taskService.delete(id);
		return "redirect:/tasks/taskList";
	}
	

}
