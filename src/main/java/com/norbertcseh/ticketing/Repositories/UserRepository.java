package com.norbertcseh.ticketing.Repositories;

import com.norbertcseh.ticketing.Entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 */
public interface UserRepository extends JpaRepository<User, Long> {

}