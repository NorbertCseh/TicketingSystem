package com.norbertcseh.ticketing.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.*;

/**
 * Profile
 */
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Profile {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String fullName;

    @NonNull
    private String displayName;

    private String avatar;

    @NonNull
    private String company;

    @NonNull
    private String position;

    @OneToOne(mappedBy = "profile")
    private User user;

}