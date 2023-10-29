package com.sgtpied.sgtpied.parameters.repositories;

import com.sgtpied.sgtpied.parameters.models.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

}
