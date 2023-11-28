package com.sgtpied.sgt.manager.repositories;

import com.sgtpied.sgt.manager.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

    public List<State> getAllByTasksid(Integer countryid);

}
