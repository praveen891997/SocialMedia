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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.socialmedia.entity.Comment;
import com.cg.socialmedia.entity.Post;
import com.cg.socialmedia.exception.ResourceNotFoundException;
import com.cg.socialmedia.repository.CommentRepo;
import com.cg.socialmedia.service.AdminCommentService;
import com.cg.socialmedia.service.CommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@CrossOrigin()
@RestController
@RequestMapping("/api")
@Api(value="social media related Rest APIs")
public class AdminCommentController {
	@Autowired
	private AdminCommentService adminCommentService;
	
	@Autowired
	private CommentRepo commentRepo;
	
	
	@ApiOperation(value ="Returns All Comments")
	
	@ApiResponses(value= {
			@ApiResponse(code=404,message="No such Comments found"),
			@ApiResponse(code=200,message="Comments found")
			
	})
	@GetMapping("admin/comments")
	public List<Comment> viewAllComments(){
		return adminCommentService.findAllComments();
	}
	
	@ApiOperation(value ="Returns comment for a specific comment Id")

	@ApiResponses(value= {
	@ApiResponse(code=404,message="No such comment found"),
	@ApiResponse(code=200,message="comment found")
	
	})
	@GetMapping("admin/comment/{cid}")
	public Comment viewCommentByCommentId(@PathVariable long cid) throws ResourceNotFoundException{
		return adminCommentService.findByCommentID(cid);
	}
	
	@ApiOperation(value ="Returns comment for a specific user Id")

	@ApiResponses(value= {
	@ApiResponse(code=404,message="No such comment found"),
	@ApiResponse(code=200,message="comment found")
	
	})
	@GetMapping("admin/comment/user/{uid}")
	public List<Comment> viewCommentByUserId(@PathVariable long uid) throws ResourceNotFoundException{
		return adminCommentService.findByUserId(uid);
	}
	
	@ApiOperation(value ="Returns comment for a specific post Id")

	@ApiResponses(value= {
	@ApiResponse(code=404,message="No such comment found"),
	@ApiResponse(code=200,message="comment found")
	
	})
	@GetMapping("admin/comment/post/{pid}")
	public List<Comment> viewCommentByPostId(@PathVariable long pid) throws ResourceNotFoundException{
		return adminCommentService.findByPostId(pid);
	}
	
	/*@DeleteMapping("admin/comment/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteComment(@PathVariable long id) throws ResourceNotFoundException{
		adminCommentService.deleteCommentById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }*/
	
	@ApiOperation(value ="Deletes comment by comment Id")
	
	@ApiResponses(value= {
			@ApiResponse(code=404,message="comment not deleted"),
			@ApiResponse(code=200,message="comment got deleted")
			
	})
	@DeleteMapping("admin/comment/{id}")
    public List<Comment> deleteComment(@PathVariable long id) throws ResourceNotFoundException{
		adminCommentService.deleteCommentById(id);
		List<Comment> list=adminCommentService.findAll();
		return list;
    }
	
	@ApiOperation(value ="Returns All usersId ")
	@ApiResponses(value= {
			@ApiResponse(code=404,message="No such comments found "),
			@ApiResponse(code=200,message="comments found")
			
	})
	@GetMapping("admin/comment/allusers")
	public List<Long> findAllUserIdComments() throws ResourceNotFoundException {
		return adminCommentService.findAllUserIdComments();	
	}
}
