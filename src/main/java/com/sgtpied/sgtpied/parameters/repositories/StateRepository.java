package com.sgtpied.sgtpied.parameters.repositories;

import com.sgtpied.sgtpied.parameters.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

    public List<State> getAllByCountryid(Integer countryid);

}
