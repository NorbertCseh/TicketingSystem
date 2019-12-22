package com.norbertcseh.ticketing.Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.*;

/**
 * Ticket
 */
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Ticket extends Auditable {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @ManyToOne
    private Project project;

    @NonNull
    private String ticketType;

    @NonNull
    private String severity;

    @NonNull
    private String priority;

    @NonNull
    private String enviroment;

    @NonNull
    private String title;

    @NonNull
    private String description;

    private String affectedVersion;

    private String fixVersion;

    @ManyToOne
    private User assignedUser;

    private String[] attachments;

    private String[] labels;

    @OneToMany
    private List<Comment> comments;

}