package com.tgj.eventaid.Repositories;

import com.tgj.eventaid.models.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketsRepository extends CrudRepository<Ticket, Long> {
}
