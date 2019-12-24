package com.norbertcseh.ticketing.Service;

import java.util.ArrayList;
import java.util.List;

import com.norbertcseh.ticketing.Entities.Ticket;
import com.norbertcseh.ticketing.Repositories.TicketRepository;

import org.springframework.stereotype.Service;

/**
 * TicketService
 */
@Service
public class TicketService {

    TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void createTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id) {
        // TODO handle if there is no ticket with this id
        return ticketRepository.findById(id).get();
    }

}