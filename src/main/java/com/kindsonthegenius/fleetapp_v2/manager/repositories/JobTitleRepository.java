package com.kindsonthegenius.fleetapp_v2.manager.repositories;

import com.kindsonthegenius.fleetapp_v2.manager.models.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTitleRepository extends JpaRepository<JobTitle, Integer> {
}
