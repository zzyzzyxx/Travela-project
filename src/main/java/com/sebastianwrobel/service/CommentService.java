package com.sebastianwrobel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebastianwrobel.domain.Comment;
import com.sebastianwrobel.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepo;
	
	public void save(Comment comment) {
		commentRepo.save(comment);
	}
}
