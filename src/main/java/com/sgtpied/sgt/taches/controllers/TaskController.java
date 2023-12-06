package com.sgtpied.sgt.taches.controllers;
import  com.sgtpied.sgt.admin.models.Role;
import com.sgtpied.sgt.admin.models.User;
import com.sgtpied.sgt.admin.services.UserService;
import com.sgtpied.sgt.taches.models.Task;
import com.sgtpied.sgt.taches.models.TaskStatus;
import com.sgtpied.sgt.taches.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping("/taches/tasks")

    public String getAllTasks(Model model, Principal principal) {
        List<Task> tasks;
        // Get the currently authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User currentUser = userService.getUserByUsername(username); // Declare and initialize currentUser

        // Log the roles for debugging
        List<String> roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        System.out.println("User Roles: " + roles);

        // Check if the user has "EMPLOYEE" role
        if (roles.contains("EMPLOYEE")) {
            // User has "EMPLOYEE" role, get tasks by assigned user
            tasks = taskService.getTasksByAssignedUser(currentUser);
        } else {
            // User has "ADMIN" or "MANAGER" role, get all tasks
            tasks = taskService.getAllTasks();
        }

        // Populate the users attribute
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("tasks", tasks);
        model.addAttribute("newTask", new Task());
        return "/taches/tasks";
    }




    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return taskService.getTasksByStatus(status);
    }



    @PostMapping("/taches/tasks")
    public String addTask(@ModelAttribute("newTask") Task newTask,
                          @RequestParam("assignedUserId") Integer assignedUserId ) {
        // Retrieve the selected user from the UserService
        User assignedUser = userService.getUserById(assignedUserId);

        // Set the assigned user for the new task
        newTask.setAssignedUser(assignedUser);

        // Assuming you have a method in TaskService to save a new task
        taskService.saveTask(newTask);

        return "redirect:/taches/tasks";
    }



    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @GetMapping("/delete/{id}")
    public ModelAndView deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return new ModelAndView("redirect:/taches/tasks");
    }


    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable Long id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task); // Add the existing task for display
        model.addAttribute("updatedTask", new Task()); // Add an empty task for the form
        return "taches/editTask";
    }


    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable Long id, @ModelAttribute Task updatedTask) {
        // Logic to update the task based on the provided updatedTask data
        taskService.updateTask(id, updatedTask);

        // Redirect to the /taches/editTask page
        return "redirect:/taches/editTask/" + id;
    }


    @GetMapping("/taches/taskStatus")
    public String getTaskStatus(Model model, Principal principal) {
        // ... (existing code)

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User currentUser = userService.getUserByUsername(username);

        // Log the roles for debugging
        List<String> roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        System.out.println("User Roles: " + roles);

        List<Task> todoTasks;
        List<Task> inProgressTasks;
        List<Task> doneTasks;
        List<Task> issueTasks;

        // Check if the user has "EMPLOYEE" role
        if (roles.contains("EMPLOYEE")) {
            // User has "EMPLOYEE" role, get tasks by assigned user and status
            todoTasks = taskService.getTasksByStatusAndAssignedUser(TaskStatus.valueOf("TODO"), currentUser);
            inProgressTasks = taskService.getTasksByStatusAndAssignedUser(TaskStatus.valueOf("IN_PROGRESS"), currentUser);
            doneTasks = taskService.getTasksByStatusAndAssignedUser(TaskStatus.valueOf("DONE"), currentUser);
            issueTasks = taskService.getTasksByStatusAndAssignedUser(TaskStatus.valueOf("ISSUE"), currentUser);
        } else {
            // User has "ADMIN" or "MANAGER" role, get all tasks by status
            todoTasks = taskService.getTasksByStatus(TaskStatus.valueOf("TODO"));
            inProgressTasks = taskService.getTasksByStatus(TaskStatus.valueOf("IN_PROGRESS"));
            doneTasks = taskService.getTasksByStatus(TaskStatus.valueOf("DONE"));
            issueTasks = taskService.getTasksByStatus(TaskStatus.valueOf("ISSUE"));
        }

        model.addAttribute("todoTasks", todoTasks);
        model.addAttribute("inProgressTasks", inProgressTasks);
        model.addAttribute("doneTasks", doneTasks);
        model.addAttribute("issueTasks", issueTasks);

        // ... (existing code)

        return "/taches/taskStatus";
    }



    // ... other methods ...

}