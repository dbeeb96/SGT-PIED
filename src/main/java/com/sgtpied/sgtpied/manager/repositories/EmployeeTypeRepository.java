package com.sgtpied.sgtpied.manager.repositories;

import com.sgtpied.sgtpied.manager.models.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeTypeRepository extends JpaRepository<EmployeeType, Integer> {

}
