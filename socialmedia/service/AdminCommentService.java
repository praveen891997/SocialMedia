package com.cg.socialmedia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.socialmedia.entity.Comment;
import com.cg.socialmedia.entity.Post;
import com.cg.socialmedia.exception.ResourceNotFoundException;
import com.cg.socialmedia.repository.AdminCommentRepo;
import com.cg.socialmedia.repository.CommentRepo;

@Service
public class AdminCommentService {
	@Autowired
	private AdminCommentRepo commentRepo;
	
	
	//to retrieve all records comment
	public List<Comment> findAllComments() {
		return commentRepo.findAll();
	}

	//to retrieve records using commentId
	public Comment findByCommentID(long id) throws ResourceNotFoundException {
		Comment comment= commentRepo.findByCommentID(id);
		if(comment==null) {
			throw new ResourceNotFoundException("not found");
		}
		else {
			return comment;
		}
	}
	
	
	//to retrieve comments posted by specific user
	public List<Comment> findByUserId(long userprofile_id) throws ResourceNotFoundException{
		List<Comment> commentList=commentRepo.findByUserID(userprofile_id); 
		if(commentList==null || commentList.isEmpty()) {
			throw new ResourceNotFoundException("not found");
		}
		else {
			return commentList;
		}
	}
	
	
	//to retrieve comments for specific post
	public List<Comment> findByPostId(long post_id) throws ResourceNotFoundException{
		List<Comment> commentList=commentRepo.findByPostID(post_id); 
		if(commentList==null || commentList.isEmpty()) {
			throw new ResourceNotFoundException("not found");
		}
		else {
			return commentList;
		}
	}
	
	
	//to delete comment using comment id
	public Integer deleteCommentById(long id) throws ResourceNotFoundException{
		Comment comment=commentRepo.findByCommentID(id);
		if(comment==null) {
			throw new ResourceNotFoundException("not found");
		}
		else {
			commentRepo.deleteById(id);
			return 1;
		}
	}
	
	
	//to view All user id comments
	public List<Long> findAllUserIdComments() throws ResourceNotFoundException{
		List<Long> commentList=commentRepo.findAlluserprofileId();
		if(commentList==null || commentList.isEmpty()) {
			throw new ResourceNotFoundException("not found");
		}
		else {
			return commentList;
		}
	}
	
	public List<Comment> findAll() throws ResourceNotFoundException{
		List<Comment> commentList=commentRepo.findAll();
		if(commentList==null || commentList.isEmpty()) {
			throw new ResourceNotFoundException("not found");
		}
		else {
			return commentList;
		}
	}
}
