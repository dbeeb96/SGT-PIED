package com.sgtpied.sgt.project.services;

import com.sgtpied.sgt.project.models.Project;
import com.sgtpied.sgt.project.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	//Get All project

	
	//Get Vehicle By Id
	public Project findById(int id) {
		return projectRepository.findById(id).orElse(null);
	}	
	
	//Delete Vehicle
	public void delete(int id) {
		projectRepository.deleteById(id);
	}
	
	//Update Vehicle
	public void save(Project vehicle) {
		projectRepository.save(vehicle);
	}

}
