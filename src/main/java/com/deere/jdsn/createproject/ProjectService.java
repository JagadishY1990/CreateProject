package com.deere.jdsn.createproject;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository projectRepo;
	
	public List<Project> getAllProjects() {
		return (List<Project>) projectRepo.findAll();
	}
	
	public Optional<Project> getProjectById(String id) {
		return projectRepo.findById(id);
	}
	
	public void addProject(Project project) {
		projectRepo.save(project);
	}
	
	public void updateProject(Project project,String id) {
		projectRepo.save(project);
	}
	
	public void deleteProject(String id) {
		projectRepo.deleteById(id);
	}

}
