package com.norbertcseh.ticketing.Repositories;

import com.norbertcseh.ticketing.Entities.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * RoleRepository
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}