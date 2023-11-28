package com.sgtpied.sgt.manager.repositories;

import com.sgtpied.sgt.manager.models.Modules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModulesRepository extends JpaRepository<Modules, Integer> {

}
