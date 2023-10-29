package com.sgtpied.sgtpied.task.repositories;

import com.sgtpied.sgtpied.task.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
