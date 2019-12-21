package com.norbertcseh.ticketing.Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.*;

/**
 * Project
 */
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @OneToMany
    private List<User> users;

    @OneToMany
    private List<Ticket> tickets;

}