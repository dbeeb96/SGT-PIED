package com.sgtpied.sgt.calandar.repository;

import com.sgtpied.sgt.calandar.model.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventsRepository extends JpaRepository<Events, Long> {

    /* Note these two methods do the same thing.  The @Repository annotation handles both*/

    /* This one uses a JPQL */
    public List<Events> findByStartGreaterThanEqualAndFinishLessThanEqual(LocalDateTime start, LocalDateTime end);


    /* This one uses an @Query */
    @Query("select b from Events b where b.start >= ?1 and b.finish <= ?2")
    public List<Events> findByDateBetween(LocalDateTime start, LocalDateTime end);

}