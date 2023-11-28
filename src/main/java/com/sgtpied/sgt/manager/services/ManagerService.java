package com.sgtpied.sgt.manager.services;

import com.sgtpied.sgt.manager.models.TaskStatus;
import com.sgtpied.sgt.manager.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
	
	@Autowired
	private ManagerRepository managerRepository;
	
	//Get All Clients
	public List<TaskStatus> findAll(){
		return managerRepository.findAll();
	}	
	
	//Get Client By Id
	public TaskStatus findById(int id) {
		return managerRepository.findById(id).orElse(null);
	}	
	
	//Delete Client
	public void deleteById(int id) {
		managerRepository.deleteById(id);
	}
	
	//Update Client
	public void save( TaskStatus client) {
		managerRepository.save(client);
	}

}
