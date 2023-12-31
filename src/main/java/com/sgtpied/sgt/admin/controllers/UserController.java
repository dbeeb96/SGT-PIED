package com.sgtpied.sgt.admin.controllers;


import com.sgtpied.sgt.admin.models.User;
import com.sgtpied.sgt.admin.services.RoleService;
import com.sgtpied.sgt.admin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

	@Autowired
    private UserService userService;
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/security/users")
	public String getUser(Model model) {
		model.addAttribute("users", userService.findAll());
		return "/security/users";
	}

	//The op parameter is either Edit or Details
	@GetMapping("/security/user/{op}/{id}")
	public String editUser(@PathVariable Integer id, @PathVariable String op, Model model){
		User user = userService.findById(id);
		model.addAttribute("user", user);
		model.addAttribute("userRoles", roleService.getUserRoles(user));
		model.addAttribute("userNotRoles", roleService.getUserNotRoles(user));
		return "/security/user"+ op; //returns employeeEdit or employeeDetails
	}

	//Modified method to Add a new user User
	@PostMapping(value="users/addNew")
	public RedirectView addNew(User user, RedirectAttributes redir) {
		
		userService.save(user);	
		
		RedirectView redirectView= new RedirectView("/login",true);
		
	    redir.addFlashAttribute("message",	"Inscription réussie vous pouvez vous connecter");
	        
	    return redirectView;				
	}

	@RequestMapping(value="/security/user/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteById(@PathVariable Integer id) {
		userService.deleteById(id);
		return "redirect:/security/users";
	}

}
