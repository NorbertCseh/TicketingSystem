package com.norbertcseh.ticketing.Repositories;

import java.util.Optional;

import com.norbertcseh.ticketing.Entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}