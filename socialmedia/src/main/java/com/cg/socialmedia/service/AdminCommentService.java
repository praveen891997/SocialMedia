package com.cg.socialmedia.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.socialmedia.Myproperties;
import com.cg.socialmedia.controller.AdminCommentController;
import com.cg.socialmedia.entity.Comment;
import com.cg.socialmedia.entity.Post;
import com.cg.socialmedia.exception.ResourceNotFoundException;
import com.cg.socialmedia.repository.AdminCommentRepo;
import com.cg.socialmedia.repository.CommentRepo;

@Service
public class AdminCommentService {
	private static final Logger Logger=LogManager.getLogger(AdminCommentService.class);
	@Autowired
	private AdminCommentRepo commentRepo;
	
	@Autowired
	Myproperties properties;
	
	
	//to retrieve all records comment
	public List<Comment> findAllComments() {
		return commentRepo.findAll();
	}

	//to retrieve records using commentId
	public Comment findByCommentID(long id) throws ResourceNotFoundException {
		Comment comment= commentRepo.findByCommentID(id);
		if(comment==null) {
			Logger.error("comment for comment id "+id+ properties.getLog().getFail());
			throw new ResourceNotFoundException("not found");
			
		}
		else {
			Logger.info("comment for comment id "+id+" "+ properties.getLog().getPass()+ comment);
			return comment;
		}
	}
	
	
	//to retrieve comments posted by specific user
	public List<Comment> findByUserId(long userprofile_id) throws ResourceNotFoundException{
		List<Comment> commentList=commentRepo.findByUserID(userprofile_id); 
		if(commentList==null || commentList.isEmpty()) {
			Logger.error("comments for user id "+userprofile_id+ properties.getLog().getFail());
			throw new ResourceNotFoundException("not found");
		}
		else {
			Logger.info("comments for user id "+userprofile_id+" "+ properties.getLog().getPass()+ commentList);
			return commentList;
		}
	}
	
	
	//to retrieve comments for specific post
	public List<Comment> findByPostId(long post_id) throws ResourceNotFoundException{
		List<Comment> commentList=commentRepo.findByPostID(post_id); 
		if(commentList==null || commentList.isEmpty()) {
			Logger.error("comments for post id "+post_id+ properties.getLog().getFail());
			throw new ResourceNotFoundException("not found");
		}
		else {
			Logger.info("comments for post id "+post_id+" "+ properties.getLog().getPass()+ commentList);
			return commentList;
		}
	}
	
	
	//to delete comment using comment id
	public Integer deleteCommentById(long id) throws ResourceNotFoundException{
		Comment comment=commentRepo.findByCommentID(id);
		if(comment==null) {
			Logger.error("comments for post id "+id+ properties.getLog().getFail());
			throw new ResourceNotFoundException("not found");
		}
		else {
			Logger.info("comment deleted "+id+" "+ comment);
			commentRepo.deleteById(id);
			return 1;
		}
	}
	
	
	//to view All user id comments
	public List<Long> findAllUserIdComments() throws ResourceNotFoundException{
		List<Long> commentList=commentRepo.findAlluserprofileId();
		if(commentList==null || commentList.isEmpty()) {
			Logger.error("user id's "+ properties.getLog().getFail());
			throw new ResourceNotFoundException("not found");
		}
		else {
			return commentList;
		}
	}
	
	//to view All post id comments
		public List<Long> findAllpostId() throws ResourceNotFoundException{
			List<Long> commentList=commentRepo.findAllpostId();
			if(commentList==null || commentList.isEmpty()) {
				Logger.error(" post id's "+ properties.getLog().getFail());
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
