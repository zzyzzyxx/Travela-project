package com.sebastianwrobel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sebastianwrobel.domain.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {

}