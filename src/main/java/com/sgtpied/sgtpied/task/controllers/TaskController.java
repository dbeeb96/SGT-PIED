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
	
	@Autowired private TaskService taskService;
	@Autowired private TaskStatusService taskStatusService;
	@Autowired private ClientService clientService;
	
	//Get All the tasks
	@GetMapping("/helpdesk/tasks")
	public String findAll(Model model){		
		model.addAttribute("tasks", taskService.findAll());
		model.addAttribute("clients", clientService.findAll());
		model.addAttribute("taskStatuses", taskStatusService.findAll());
		return "/helpdesk/tasks";
	}	
	
	@RequestMapping("/tasks/findById")
	@ResponseBody
	public Optional<Task> findById(Integer id)
	{
		return taskService.findById(id);
	}
	
	//Add Task
	@PostMapping(value="/tasks/addNew")
	public String addNew(Task task) {
		taskService.save(task);
		return "redirect:/taskList";
	}	
	
	@RequestMapping(value="/tasks/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Task task) {
		taskService.save(task);
		return "redirect:/tasktList";
	}
	
	@RequestMapping(value="/tasks/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		taskService.delete(id);
		return "redirect:/taskList";
	}
}
