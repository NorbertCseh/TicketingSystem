package com.norbertcseh.ticketing.Repositories;

import com.norbertcseh.ticketing.Entities.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CommentRepository
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {

}