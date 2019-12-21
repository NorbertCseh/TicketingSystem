package com.norbertcseh.ticketing.Entities;

import java.util.List;

/**
 * Ticket
 */
public class Ticket {

    private Long id;

    private Boolean isExternal;

    private String ticketType;

    private String severity;

    private String priority;

    private String enviroment;

    private String title;

    private String description;

    private String affectedVersion;

    private String fixVersion;

    private User reporter;

    private User assignedUser;

    private List<String> attachments;

    private List<String> labels;

    private List<Ticket> linkedTickets;

    private List<Comment> comments;

}