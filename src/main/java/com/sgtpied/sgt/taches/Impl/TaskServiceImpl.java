package com.sgtpied.sgt.taches.Impl;

import com.sgtpied.sgt.admin.models.User;
import com.sgtpied.sgt.taches.models.Task;
import com.sgtpied.sgt.taches.models.TaskStatus;
import com.sgtpied.sgt.taches.repositories.TaskRepository;
import com.sgtpied.sgt.taches.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;


    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }
   @Override
    public List<Task> getTasksByAssignedUser(User user) {
        return taskRepository.findByAssignedUser(user);
    }
    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }
    @Override
    public void updateTask(Long id, Task updatedTask) {
        // Retrieve the existing task from the database
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found with id: " + id));

        // Update the fields of the existing task with the new values
        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setStatus(updatedTask.getStatus());
        existingTask.setStartDate(updatedTask.getStartDate());
        existingTask.setEndDate(updatedTask.getEndDate());

        // Save the updated task back to the database
        taskRepository.save(existingTask);
    }
}
