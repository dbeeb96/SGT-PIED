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
	
	//Get All TaskStatuss
	@GetMapping("/task/taskStatuses")
	public String findAll(Model model){		
		model.addAttribute("taskStatuses", taskStatusService.findAll());
		return "/task/taskStatuses";
	}	
	
	@RequestMapping("/task/taskStatus/{id}")
	@ResponseBody
	public Optional<TasktStatus> findById(@PathVariable Integer id)
	{
		return taskStatusService.findById(id);
	}
	
	//Add taskStatus
	@PostMapping(value="/task/taskStatuses")
	public String addNew(TasktStatus taskStatus) {
		taskStatusService.save(taskStatus);
		return "redirect:/task/taskStatuses";
	}
	
	@RequestMapping(value="helpdesk/taskStatus/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable Integer id) {
		taskStatusService.delete(id);
		return "redirect:/helpdesk/taskStatuses";
	}
}
