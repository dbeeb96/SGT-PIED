package com.sgtpied.sgtpied.task.controllers;

import com.sgtpied.sgtpied.task.models.Task;
import com.sgtpied.sgtpied.task.services.TaskService;
import com.sgtpied.sgtpied.task.services.TaskStatusService;
import com.sgtpied.sgtpied.parameters.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
public class TaskController {
	
	@Autowired private TaskService ticketService;
	@Autowired private TaskStatusService ticketStatusService;
	@Autowired private ClientService clientService;
	
	//Get All Tickets
	@GetMapping("/helpdesk/tasks")
	public String findAll(Model model){		
		model.addAttribute("tasks", ticketService.findAll());
		model.addAttribute("clients", clientService.findAll());
		model.addAttribute("ticketStatuses", ticketStatusService.findAll());
		return "/helpdesk/tasks";
	}	
	
	@RequestMapping("/tasks/findById")
	@ResponseBody
	public Optional<Task> findById(Integer id)
	{
		return ticketService.findById(id);
	}
	
	//Add Ticket
	@PostMapping(value="/tickets/addNew")
	public String addNew(Task task) {
		ticketService.save(task);
		return "redirect:/taskList";
	}	
	
	@RequestMapping(value="/tasks/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Task task) {
		ticketService.save(task);
		return "redirect:/ticketList";
	}
	
	@RequestMapping(value="/tasks/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		ticketService.delete(id);
		return "redirect:/taskList";
	}
}
