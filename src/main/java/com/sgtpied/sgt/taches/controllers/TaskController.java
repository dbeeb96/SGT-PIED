package com.sgtpied.sgt.taches.controllers;

import com.sgtpied.sgt.admin.models.User;
import com.sgtpied.sgt.admin.services.UserService;
import com.sgtpied.sgt.taches.models.Task;
import com.sgtpied.sgt.taches.models.TaskStatus;
import com.sgtpied.sgt.taches.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

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
        User currentUser = userService.getUserByUsername(username);

        // Check if the user has either "EMPLOYEE" or "ADMIN" role
        if (currentUser.getRoles().stream().anyMatch(role -> role.getName().equals("EMPLOYEE") || role.getName().equals("ADMIN"))) {
            // User has "EMPLOYEE" or "ADMIN" role, get tasks by assigned user
           tasks = taskService.getTasksByAssignedUser(currentUser);
        } else {
            // User doesn't have "EMPLOYEE" or "ADMIN" role, get all tasks
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



    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/taches/tasks";
    }

   @GetMapping("/edit/{id}")
    public String editTask(@PathVariable Long id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task); // Add the existing task for display
        model.addAttribute("updatedTask", new Task()); // Add an empty task for the form
        return "taches/editTask";
    }


        // ... other methods ...

        @PostMapping("/taches/tasks/update/{id}")
        public String updateTask(@PathVariable Long id, @ModelAttribute Task updatedTask, Model model) {
            // Logic to update the task based on the provided updatedTask data
            taskService.updateTask(id, updatedTask);
            // Redirect to the /taches/tasks page
            return "redirect:/taches/tasks";

        }

        // ... other methods ...

}
