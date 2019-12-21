package com.norbertcseh.ticketing.Repositories;

import com.norbertcseh.ticketing.Entities.Project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ProjectRepository
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}