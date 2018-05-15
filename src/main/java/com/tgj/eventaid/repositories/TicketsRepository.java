package com.tgj.eventaid.repositories;

import com.tgj.eventaid.models.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketsRepository extends CrudRepository<Ticket, Long> {

//    @Query(value = "select count(event_id) from event_tickets where event_id=?1", nativeQuery = true)
//    int countByEvent_id(int id);

}
