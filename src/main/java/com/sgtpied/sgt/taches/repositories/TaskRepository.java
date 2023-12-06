package com.sgtpied.sgt.taches.repositories;

import com.sgtpied.sgt.admin.models.User;
import com.sgtpied.sgt.taches.models.Task;
import com.sgtpied.sgt.taches.models.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus status);
    List<Task> findByAssignedUser(User user);

    Optional<Task> findById(Long id);

    List<Task> findByStatusAndAssignedUser(TaskStatus status, User assignedUser);

}
