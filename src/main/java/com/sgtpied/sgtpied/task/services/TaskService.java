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
	
	//Get All Tickets
	public List<Task> findAll(){
		return invoiceRepository.findAll();
	}	
	
	//Get Ticket By Id
	public Optional<Task> findById(int id) {
		return invoiceRepository.findById(id);
	}	
	
	//Delete Ticket
	public void delete(int id) {
		invoiceRepository.deleteById(id);
	}
	
	//Update Ticket
	public void save(Task invoice) {
		invoiceRepository.save(invoice);
	}

}
