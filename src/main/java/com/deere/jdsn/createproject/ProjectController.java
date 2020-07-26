package com.deere.jdsn.createproject;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@GetMapping("/projects")
	public List<Project> getAllProjects() {
		return projectService.getAllProjects();
	}
	
	@GetMapping("/projects/{id}")
	public Optional<Project> getProjectById(@PathVariable String id) {
		return projectService.getProjectById(id);
	}
	
	@PostMapping("/addProjects")
	public void addProject(@RequestBody Project project) {
		projectService.addProject(project);
	}
	
	@PutMapping("/updateProjects/{id}")
	public void updateProject(@RequestBody Project project,@PathVariable String id) {
		projectService.updateProject(project, id);
	}
	
	@DeleteMapping("/deleteProject/{id}")
	public void deleteProject(@PathVariable String id) {
		projectService.deleteProject(id);
	}
	
	@RequestMapping(value="/retrieveAndaddProjects", method= {RequestMethod.GET,RequestMethod.POST})
	public List<Project> retrieveAndaddProjects(@RequestBody Project project) {
		projectService.addProject(project);
		return getAllProjects();
	}
	
	@RequestMapping(value="/retrieveAndupdateProject", method= {RequestMethod.GET,RequestMethod.POST})
	public List<Project> retrieveAndupdateProject(@RequestBody Project project) {
		projectService.updateProject(project, project.getId());
		return getAllProjects();
	}
	
	@RequestMapping(value="/retrieveAnddeleteProject", method= {RequestMethod.GET,RequestMethod.POST})
	public List<Project> retrieveAnddeleteProject(@RequestParam String id) {
		projectService.deleteProject(id);
		return getAllProjects();
	}

}
