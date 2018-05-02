package com.tgj.eventaid.repositories;

import com.tgj.eventaid.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends CrudRepository<Event, Long>{


}
