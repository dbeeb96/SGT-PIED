package com.sgtpied.sgt.taches.controllers;

import com.sgtpied.sgt.taches.models.Task;
import com.sgtpied.sgt.taches.models.TaskStatus;
import com.sgtpied.sgt.taches.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/taches/tasks")
    public String getAllTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        model.addAttribute("newTask", new Task()); // Add an empty task for the form
        return "/taches/tasks";
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return taskService.getTasksByStatus(status);
    }


    @PostMapping("/taches/tasks")
    public String addTask(@ModelAttribute Task newTask, Model model) {
        taskService.saveTask(newTask);
        // Retrieve all tasks including the new one
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        model.addAttribute("newTask", new Task()); // Add an empty task for the form
        return "redirect:/taches/tasks"; // Redirect to the tasks page to avoid form resubmission
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
        return "/taches/editTask";
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
