package com.sgtpied.sgt.manager.controllers;

import com.sgtpied.sgt.manager.models.TaskStatus;
import com.sgtpied.sgt.manager.services.ManagerService;
import com.sgtpied.sgt.manager.services.StateService;
import com.sgtpied.sgt.manager.services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class managerController {

	@Autowired	private ManagerService managerService;
	@Autowired	private TasksService countryService;
	@Autowired	private StateService stateService;

	public Model addModelAttributes(Model model){
		model.addAttribute("clients", managerService.findAll());
		model.addAttribute("tasks", countryService.findAll());
		model.addAttribute("states", stateService.findAll());
		return model;
	}

	@GetMapping("/parameters/clients")
	public String findAll(Model model){
		addModelAttributes(model);
		return "/parameters/clients";
	}

	@GetMapping("/parameters/clientAdd")
	public String addClient(Model model){
		model.addAttribute("countries", countryService.findAll());
		return "parameters/clientAdd";
	}
	//The op parameter is either Edit or Details
	@GetMapping("/parameters/client/{op}/{id}")
	public String editClient(@PathVariable Integer id, @PathVariable String op, Model model){
		TaskStatus client = managerService.findById(id);
		model.addAttribute("client", client);
		addModelAttributes(model);
		return "/parameters/client"+ op; //returns clientEdit or clientDetails
	}

	@PostMapping("/parameters/clients")
	public String save(TaskStatus client) {
		managerService.save(client);
		return "redirect:/parameters/clients";
	}

	@RequestMapping(value="/parameters/clients/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteById(@PathVariable Integer id) {
		managerService.deleteById(id);
		return "redirect:/parameters/clients";
	}
}
