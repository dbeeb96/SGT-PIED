package com.kindsonthegenius.fleetapp_v2.project.repositories;

import com.kindsonthegenius.fleetapp_v2.project.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
