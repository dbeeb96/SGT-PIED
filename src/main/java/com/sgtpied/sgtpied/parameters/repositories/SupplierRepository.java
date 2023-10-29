package com.sgtpied.sgtpied.parameters.repositories;

import com.sgtpied.sgtpied.parameters.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
