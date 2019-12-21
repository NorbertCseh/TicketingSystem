package com.norbertcseh.ticketing.Repositories;

import com.norbertcseh.ticketing.Entities.Profile;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ProfileRepository
 */
public interface ProfileRepository extends JpaRepository<Profile, Long> {

}