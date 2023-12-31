package com.sgtpied.sgt.manager.repositories;

import com.sgtpied.sgt.manager.models.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

}
