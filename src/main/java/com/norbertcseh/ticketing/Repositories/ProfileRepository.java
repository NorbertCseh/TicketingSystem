package com.norbertcseh.ticketing.Repositories;

import com.norbertcseh.ticketing.Entities.Profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ProfileRepository
 */
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

}