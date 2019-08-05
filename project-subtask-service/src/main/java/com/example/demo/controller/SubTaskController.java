package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.SubTask;
import com.example.demo.service.SubTaskService;



@RestController
@RequestMapping("/api")
public class SubTaskController {

	private SubTaskService service;
	
	@Autowired
	public SubTaskController(SubTaskService service) {
		super();
		this.service = service;
	}

	
	public SubTaskController() {
		super();
	
	}
	
	@RequestMapping("/")
	public String home()
	{ 
		return "welome to home...";
	}
	@RequestMapping("/subtasks")
	public List<SubTask> getAllSubTask(){
		return service.getAllSubTask();
	}
	
	@PostMapping("/subtasks")
	public ResponseEntity<?> createSubTask(@RequestBody SubTask subtask){
		subtask.setId(0);
		service.createSubTask(subtask);
		return ResponseEntity.ok().body("SubTask Created..");
	}
	
	
	
    @GetMapping("/subtasks/{id}")
	public SubTask findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@GetMapping("/subtasks/getByTaskId/{id}")
	public List<SubTask> findByTaskId(@PathVariable int id) {
		return service.findByTaskId(id);

	}
	
	@GetMapping("/subtasks/developers")
	public List<com.example.demo.entity.UserAccount> findAllTeamLeaders() {
		return service.findAllDeveloper();
	}
	
	@GetMapping("/subtasks/getByUserId/{id}")
	public List<SubTask> findSubTaskByUserId(@PathVariable int id) {
		return service.findSubTaskByUserId(id);
	}

	
	@DeleteMapping("/subtasks/{id}")
	public ResponseEntity<?> deleteSubTask(@PathVariable int id) {
		service.deleteById(id);
		return ResponseEntity.ok().body("Subtask deleted successfully");
	}
	
	@PutMapping("/subtasks")
	public ResponseEntity<?> updateSubTask(@RequestBody SubTask subtask){
		service.createSubTask(subtask);
		return ResponseEntity.ok().body("updated....");
	}
}

