package com.sgtpied.sgtpied.task.services;

import com.sgtpied.sgtpied.task.models.TasktStatus;
import com.sgtpied.sgtpied.task.repositories.TaskStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskStatusService {
	
	@Autowired
	private TaskStatusRepository taskStatusRepository;
	
	//Get All TicketStatuss
	public List<TasktStatus> findAll(){
		return taskStatusRepository.findAll();
	}	
	
	//Get TicketStatus By Id
	public Optional<TasktStatus> findById(int id) {
		return taskStatusRepository.findById(id);
	}	
	
	//Delete TicketStatus
	public void delete(int id) {
		taskStatusRepository.deleteById(id);
	}
	
	//Update TicketStatus
	public void save(TasktStatus ticketStatus) {
		taskStatusRepository.save(ticketStatus);
	}

}
