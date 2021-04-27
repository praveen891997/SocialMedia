package com.cg.socialmedia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.socialmedia.entity.Comment;
import com.cg.socialmedia.exception.ResourceNotFoundException;
import com.cg.socialmedia.repository.CommentRepo;
import com.cg.socialmedia.service.CommentService;

@RestController
@CrossOrigin()
@RequestMapping("/api")
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@PostMapping("/comment")
	public Comment createComment(@RequestBody Comment comment) {
		return commentService.uploadComment(comment);
	}
	@GetMapping("/comments")
	public List<Comment> viewAllComments(){
		return commentService.viewAllComments();
	}
	
	@GetMapping("/comment/{id}")
	public Comment searchByCommentID(@PathVariable long id) throws ResourceNotFoundException {
		Comment result = commentRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Sorry! No comment found with this id : "+id));
		Comment comment = commentService.searchByCommentID(id);
		return comment;
	}
	
	@DeleteMapping("/comment/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteComment(@PathVariable long id) throws ResourceNotFoundException{
        Comment comment = commentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not exist with id :" + id));
       
        commentRepo.delete(comment);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
