package com.sgtpied.sgtpied.task.services;

import com.sgtpied.sgtpied.task.models.Task;
import com.sgtpied.sgtpied.task.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository invoiceRepository;
	
	//Get All Tasks
	public List<Task> findAll(){
		return invoiceRepository.findAll();
	}	
	
	//Get Task By Id
	public Optional<Task> findById(int id) {
		return invoiceRepository.findById(id);
	}	
	
	//Delete Task
	public void delete(int id) {
		invoiceRepository.deleteById(id);
	}
	
	//Update Task
	public void save(Task invoice) {
		invoiceRepository.save(invoice);
	}

}
