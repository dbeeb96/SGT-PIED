package com.sgtpied.sgt.taches.repositories;

import com.sgtpied.sgt.taches.models.Task;
import com.sgtpied.sgt.taches.models.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {


    Long countTasksByStatus(TaskStatus status);

    @Transactional
    @Modifying
    @Query("UPDATE Task SET position = position + 1 WHERE position >= :position AND status = :status AND id <> :id")
    void incrementBelow(@Param("position") Long position, @Param("status") TaskStatus status, @Param("id") String id);

    @Transactional
    @Modifying
    @Query("UPDATE Task SET position = position - 1 WHERE position >= :position AND status = :status AND id <> :id")
    void decrementBelow(@Param("position") Long position, @Param("status") TaskStatus status, @Param("id") String id);

    @Transactional
    @Modifying
    @Query("UPDATE Task SET position = position + 1 WHERE position >= :newPosition AND position < :oldPosition AND status = :status AND id <> :id")
    void incrementBelowToPosition(@Param("newPosition") Long newPosition, @Param("oldPosition") Long oldPosition, @Param("status") TaskStatus status,
                                  @Param("id") String id);

    @Transactional
    @Modifying
    @Query("UPDATE Task SET position = position - 1 WHERE position <= :newPosition AND position > :oldPosition AND status = :status AND id <> :id")
    void decrementAboveToPosition(@Param("newPosition") Long newPosition, @Param("oldPosition") Long oldPosition, @Param("status") TaskStatus status,
                                  @Param("id") String id);
}
