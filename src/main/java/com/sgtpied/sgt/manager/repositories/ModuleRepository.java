package com.sgtpied.sgt.manager.repositories;

import com.sgtpied.sgt.manager.models.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Integer> {
}
