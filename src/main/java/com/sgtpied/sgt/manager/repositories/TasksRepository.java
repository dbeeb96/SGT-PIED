package com.sgtpied.sgt.manager.repositories;

import com.sgtpied.sgt.manager.models.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Integer> {

    @Query(value = "SELECT c FROM Tasks c" +
            " where concat(c.titre, c.description, c.start_date, c.end_date, c.status)" +
            " LIKE %?1%")
    List<Tasks> findByKeyword(String keyword);

}
