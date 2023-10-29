package com.sgtpied.sgtpied.task.controllers;

import com.sgtpied.sgtpied.task.models.TasktStatus;
import com.sgtpied.sgtpied.task.services.TaskStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class TaskStatusController {

	@Autowired private TaskStatusService taskStatusService;
	
	//Get All TicketStatuss
	@GetMapping("/helpdesk/ticketStatuses")
	public String findAll(Model model){		
		model.addAttribute("ticketStatuses", taskStatusService.findAll());
		return "/helpdesk/ticketStatuses";
	}	
	
	@RequestMapping("/helpdesk/ticketStatus/{id}")
	@ResponseBody
	public Optional<TasktStatus> findById(@PathVariable Integer id)
	{
		return taskStatusService.findById(id);
	}
	
	//Add TicketStatus
	@PostMapping(value="/helpdesk/ticketStatuses")
	public String addNew(TasktStatus taskStatus) {
		taskStatusService.save(taskStatus);
		return "redirect:/helpdesk/ticketStatuses";
	}
	
	@RequestMapping(value="helpdesk/ticketStatus/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable Integer id) {
		taskStatusService.delete(id);
		return "redirect:/helpdesk/ticketStatuses";
	}
}
