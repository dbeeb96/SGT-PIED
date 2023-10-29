package com.sgtpied.sgtpied.project.repositories;

import com.sgtpied.sgtpied.project.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
