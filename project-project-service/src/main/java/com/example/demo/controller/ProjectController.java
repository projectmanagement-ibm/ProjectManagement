package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

import com.example.demo.entity.Project;
import com.example.demo.entity.User;
import com.example.demo.entity.UserAccount;
import com.example.demo.service.ProjectService;


@RestController
@RequestMapping("/api")
public class ProjectController {
	
	private ProjectService projectService;

	@Autowired
	public ProjectController(ProjectService projectService) {
		super();
		this.projectService = projectService;
	}	
	
	@GetMapping("/projects")
	public List<Project> showProject(Model theModel)
	{
		return projectService.findAll();
	}
	
	@GetMapping("/projects/{id}")
	public Project findById(@PathVariable int id)
	{
		return projectService.findById(id);
	}

	@GetMapping("/projects/getProjects/{id}")
	public List<Project> findProjectByUserId(@PathVariable int id) {
		return projectService.findProjectByUserId(id);
	}
  
	@PostMapping("/projects")
	public String save(@RequestBody Project project)
	{
		projectService.save(project);

		return "Project added successfully";
	}
	
	
	@PutMapping("/projects")
	public String update(@RequestBody Project project)
	{
		projectService.save(project);

		return "Project updated successfully";
	}
	
	@DeleteMapping("/projects/{id}")
	public String delete(@PathVariable int id) {
		
		// delete the employee
		projectService.deleteById(id);
		
		return "Project deleted successfully";
		
	}
	
	@GetMapping("/projects/managers")
	List<UserAccount> findAllManager() {
		return this.projectService.findAllManager();
	}
	
//	@GetMapping("/search")
//	public String search(@RequestParam("name") String theName,
//						 Model theModel) {
//		
//		// check names, if both are empty then just give list of all employees
//
//		if (theName.trim().isEmpty()) {
//			return "redirect:/projects/list";
//		}
//		else {
//			// else, search by first name and last name
//			List<Project> theProjects =
//							projectService.searchBy(theName);
//			
//			// add to the spring model
//			theModel.addAttribute("projectList", theProjects);
//			
//			// send to list-employees
//			return "projectlist-page";
//		}
//		
//	}
}

