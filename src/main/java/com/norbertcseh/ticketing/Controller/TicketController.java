package com.norbertcseh.ticketing.Controller;

import java.util.ArrayList;

import com.norbertcseh.ticketing.Entities.Ticket;
import com.norbertcseh.ticketing.Service.TicketService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TicketController
 */
@RestController
@CrossOrigin
public class TicketController {

    TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/api/ticket/all")
    public ArrayList<Ticket> getAllTicket() {
        return (ArrayList<Ticket>) ticketService.findAll();
    }

    @GetMapping("/api/ticket/{id}")
    public Ticket getTicketById(@PathVariable Long id) {
        return ticketService.getTicketById(id);
    }

    @PostMapping("/api/ticket/createNewTicket")
    public void createNewTicket(Ticket ticket) {
        ticketService.createTicket(ticket);
    }

}