package com.example.projectv1.controller;

import java.util.List;
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

import com.example.projectv1.entity.Project;
import com.example.projectv1.service.ProjectService;




@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	private ProjectService projectService;

	@Autowired
	public ProjectController(ProjectService projectService) {
		super();
		this.projectService = projectService;
	}
	
	@GetMapping("/list")
	public String showProject(Model theModel)
	{
		theModel.addAttribute("projectList", projectService.findAll());
		return "projectlist-page";
	}

   @RequestMapping("/addproject")
	public String addProject(Model theModel)
	{
       Project theProject = new Project();
       theModel.addAttribute("project", theProject);
  		return "add-project";
  		
	}
   
   
   @GetMapping("/update")
	public String showFormForUpdate(@RequestParam("id") int id,
									Model theModel) {
		
		// get the employee from the service
		Optional<Project> theProject = projectService.findById(id);
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("project", theProject);
		
		// send over to our form
		return "add-project";			
	}
   
	@RequestMapping("/save")
	public String showsaved(@ModelAttribute("project") @Valid Project theProject, BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			return "add-project";
		}
		else {
		projectService.save(theProject);
	}
		return "redirect:/projects/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		
		// delete the employee
		projectService.deleteById(id);
		
		// redirect to /employees/list
		return "redirect:/projects/list";
		
	}
	@GetMapping("/search")
	public String search(@RequestParam("name") String theName,
						 Model theModel) {
		
		// check names, if both are empty then just give list of all employees

		if (theName.trim().isEmpty()) {
			return "redirect:/projects/list";
		}
		else {
			// else, search by first name and last name
			List<Project> theProjects =
							projectService.searchBy(theName);
			
			// add to the spring model
			theModel.addAttribute("projectList", theProjects);
			
			// send to list-employees
			return "projectlist-page";
		}
		
	}
}

