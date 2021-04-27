package com.cg.socialmedia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.socialmedia.entity.Comment;
import com.cg.socialmedia.repository.CommentRepo;

@Service
public class CommentService {
	@Autowired
	private CommentRepo commentRepo;
	
	public Comment uploadComment(Comment comment) {
		return commentRepo.save(comment);
	}

	public List<Comment> viewAllComments() {
		return commentRepo.findAll();
	}

	public Comment searchByCommentID(long id) {
		return commentRepo.findByCommentID(id);
	}
	

}
