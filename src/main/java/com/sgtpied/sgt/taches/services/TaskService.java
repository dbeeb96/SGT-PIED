package com.frontbackend.springboot.service;

import java.util.List;

import com.sgtpied.sgt.taches.models.Task;
import com.sgtpied.sgt.taches.models.TaskRequest;
import com.sgtpied.sgt.taches.models.TaskStatus;
import com.sgtpied.sgt.taches.repositories.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task create(TaskRequest taskRequest) {
        Task task = new Task();
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setStatus(TaskStatus.TODO);
        task.setPosition(taskRepository.countTasksByStatus(TaskStatus.TODO));
        return taskRepository.save(task);
    }

    @Transactional
    public void changePosition(TaskRequest taskRequest) {
        Task task = taskRepository.findById(taskRequest.getId()).orElseThrow(null);
                //.orElseThrow(TaskNotFoundException::new);

        Long oldPosition = task.getPosition();
        Long newPosition = taskRequest.getPosition();
        TaskStatus oldStatus = task.getStatus();

        if (oldStatus.equals(taskRequest.getStatus())) {
            if (newPosition > oldPosition) {
                taskRepository.decrementAboveToPosition(newPosition, oldPosition, oldStatus, task.getId());
            } else {
                taskRepository.incrementBelowToPosition(newPosition, oldPosition, oldStatus, task.getId());
            }

            task.setPosition(taskRequest.getPosition());
            taskRepository.save(task);
        } else {
            TaskStatus newStatus = taskRequest.getStatus();

            taskRepository.decrementBelow(task.getPosition(), oldStatus, task.getId());
            taskRepository.incrementBelow(taskRequest.getPosition(), newStatus, task.getId());

            task.setPosition(taskRequest.getPosition());
            task.setStatus(taskRequest.getStatus());
            taskRepository.save(task);
        }
    }

    @Transactional
    public Task update(TaskRequest taskRequest) {
        Task task = taskRepository.findById(taskRequest.getId()).orElseThrow(null);
                //.orElseThrow(TaskNotFoundException::new);
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        return taskRepository.save(task);
    }

    @Transactional
    public void delete(String id) {
        Task task = taskRepository.findById(id).orElseThrow(null);
                //.orElseThrow(TaskNotFoundException::new);
        taskRepository.decrementBelow(task.getPosition(), task.getStatus(), task.getId());
        taskRepository.deleteById(id);
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }
}