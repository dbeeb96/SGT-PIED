package com.sgtpied.sgtpied.parameters.repositories;

import com.sgtpied.sgtpied.parameters.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
