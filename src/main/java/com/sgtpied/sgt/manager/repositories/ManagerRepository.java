package com.sgtpied.sgt.manager.repositories;

import com.sgtpied.sgt.manager.models.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<TaskStatus, Integer> {

}
