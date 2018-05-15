package com.tgj.eventaid.repositories;

import com.tgj.eventaid.models.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends CrudRepository<Event, Long>{
    Iterable<Event> findAllByName(String name);

    @Query("select e from Event e where e.name like %?1% or e.location like %?1% or e.description like %?1%")
    Iterable<Event> findAllLikeName(String name);

    Event findByUrl(String url);
}
