package com.sgtpied.sgt.manager.controllers;

import com.sgtpied.sgt.manager.models.Location;
//import com.sgtpied.sgt.manager.models.Tasks;
import com.sgtpied.sgt.manager.services.LocationService;
import com.sgtpied.sgt.manager.services.StateService;
//import com.sgtpied.sgt.manager.services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LocationController {
	
	@Autowired	private LocationService locationService;
	//@Autowired	private TasksService tasksService;
	@Autowired	private StateService stateService;

	public Model addModelAttributes(Model model){
		model.addAttribute("locations", locationService.findAll());
		//model.addAttribute("tasks", tasksService.findAll());
		model.addAttribute("states", stateService.findAll());
		return model;
	}
	
	@GetMapping("/parameters/locations")
	public String findAll(Model model){
		addModelAttributes(model);
		return "/parameters/locations";
	}

	@GetMapping("/parameters/locationAdd")
	public String addLocation(Model model){
		//model.addAttribute("tasks", tasksService.findAll());
		return "parameters/locationAdd";
	}

	//The op parameter is either Edit or Details
	@GetMapping("/parameters/location/{op}/{id}")
	public String editLocation(@PathVariable Integer id, @PathVariable String op, Model model){
		Location location = locationService.findById(id);
		model.addAttribute("location", location);
		addModelAttributes(model);
		return "/parameters/location"+ op; //returns locationEdit or locationDetails
	}

	@PostMapping("/parameters/locations")
	public String save(Location location) {
		locationService.save(location);
		return "redirect:/parameters/locations";
	}
	
	@RequestMapping(value="/parameters/locations/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteById(@PathVariable Integer id) {
		locationService.deleteById(id);
		return "redirect:/parameters/locations";
	}
	
}
