package com.norbertcseh.ticketing.Repositories;

import com.norbertcseh.ticketing.Entities.Ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TicketRepository
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}