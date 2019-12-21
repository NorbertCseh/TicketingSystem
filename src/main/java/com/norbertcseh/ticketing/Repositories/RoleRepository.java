package com.norbertcseh.ticketing.Repositories;

import com.norbertcseh.ticketing.Entities.Role;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * RoleRepository
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}