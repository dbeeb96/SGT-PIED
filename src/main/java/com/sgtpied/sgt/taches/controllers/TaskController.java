package com.frontbackend.springboot.controller;

import      java.util.List;
import com.sgtpied.sgt.taches.models.Task;
import com.sgtpied.sgt.taches.models.TaskRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.frontbackend.springboot.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class    TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PutMapping("{id}")
    public Task update(@PathVariable("id") String id, @RequestBody TaskRequest taskRequest) {
        return taskService.update(taskRequest);
    }

    @PostMapping
    public Task create(@RequestBody TaskRequest taskRequest) {
        return taskService.create(taskRequest);
    }

    @PostMapping("/position")
    public void changePosition(@RequestBody TaskRequest taskRequest) {
        taskService.changePosition(taskRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        taskService.delete(id);
    }

    @GetMapping("/taches/tache")
    public List<Task> list() {
        return taskService.getAll();
    }
}