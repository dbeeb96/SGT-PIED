package com.sgtpied.sgtpied.task.repositories;

import com.sgtpied.sgtpied.task.models.TasktStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskStatusRepository extends JpaRepository<TasktStatus, Integer> {

}
