package com.tgj.eventaid.repositories;

import com.tgj.eventaid.models.Tickets;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketsRepository extends CrudRepository<Tickets, Long> {
}
