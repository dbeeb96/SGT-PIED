package com.sgtpied.sgt.taches.services;

import com.sgtpied.sgt.taches.models.Task;
import com.sgtpied.sgt.admin.models.User;
import com.sgtpied.sgt.taches.models.TaskStatus;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    List<Task> getTasksByStatus(TaskStatus status);
    List<Task> getTasksByAssignedUser(User user);
    Task getTaskById(Long id);
    Task saveTask(Task task);
    void deleteTask(Long id);
    void updateTask(Long id, Task updatedTask);
}
