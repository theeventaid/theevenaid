package com.gygproductions.blog.repositories;

import com.tgj.eventaid.models.event_tickets;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sun.security.krb5.internal.Ticket;

@Repository
public interface AdRepository extends CrudRepository<Ticket, > {
}
