package com.example.projectv1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.projectv1.entity.SubTask;
import com.example.projectv1.entity.User;
import com.example.projectv1.service.SubTaskService;


@Controller
@RequestMapping("/subtasks")
public class SubTaskController {
	
	private SubTaskService subTaskService;

	@Autowired
	public SubTaskController(SubTaskService subTaskservice) {
		super();
		this.subTaskService = subTaskservice;
	}

	@GetMapping("/list")
	public String getAllSubTask(Model theModel) {
		theModel.addAttribute("subTaskList", subTaskService.findAll());

		return "subtask-list";
	}

	@RequestMapping("/addSubTask")
	public String addSubTask(@RequestParam("id") int taskId, Model theModel) {
		SubTask subTask = new SubTask();
		subTask.setTaskId(taskId);

		theModel.addAttribute("subTask", subTask);
		
		List<User> developers = subTaskService.findAllDeveloper();
		theModel.addAttribute("developers", developers);
		return "add-subtask";
	}

	@RequestMapping("/saveSubTask")
	public String saveSubTask(@ModelAttribute("subTask") @Valid SubTask theSubTask, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "add-subtask";
		} else {

			subTaskService.save(theSubTask);
		}

		return "redirect:/subtasks/list";
	}

	@RequestMapping("/updateSubTask")
	public String updateSubTask(@RequestParam("id") int id, Model theModel) {

		SubTask subTask = subTaskService.findById(id);

		theModel.addAttribute("subTask", subTask);
		return "add-subtask";
	}

	@RequestMapping("/deleteSubTask")
	public String deleteSubTask(@RequestParam("id") int id) {
		subTaskService.delete(id);
		return "redirect:/subtasks/list";
	}

	@RequestMapping("/findByTaskId")
	public String findByTaskId(@RequestParam("id") int id, Model theModel) {
		theModel.addAttribute("subTaskList", subTaskService.findByTaskId(id));
		theModel.addAttribute("tId", id);
		return "subtask-list";

	}


}
