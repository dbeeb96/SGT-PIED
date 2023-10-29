package com.sgtpied.sgtpied.manager.repositories;

import com.sgtpied.sgtpied.manager.models.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTitleRepository extends JpaRepository<JobTitle, Integer> {
}
