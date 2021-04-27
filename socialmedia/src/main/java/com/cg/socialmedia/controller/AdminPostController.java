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

import com.cg.socialmedia.entity.Post;
import com.cg.socialmedia.exception.ResourceNotFoundException;
import com.cg.socialmedia.repository.PostRepo;
import com.cg.socialmedia.service.AdminPostService;
import com.cg.socialmedia.service.PostService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin()
@RequestMapping("/api")
@Api(value="social media related Rest APIs")
public class AdminPostController {
	@Autowired
	private AdminPostService adminpostService;
	
	@Autowired
	private PostRepo postRepo;
	
//returns all posts	
@ApiOperation(value ="Returns All Posts")
	
	@ApiResponses(value= {
			@ApiResponse(code=404,message="No such posts found"),
			@ApiResponse(code=200,message="posts found")
			
	})
	@GetMapping("admin/post")
	public List<Post> findAllPost() throws ResourceNotFoundException {
		return adminpostService.viewAllPosts();	
	}

//returns post by post Id
	@ApiOperation(value ="Returns post for a specific post Id")

		@ApiResponses(value= {
		@ApiResponse(code=404,message="No such post found"),
		@ApiResponse(code=200,message="post found")
		
		})
	@GetMapping("admin/post/{pid}")
	public Post findByPostId(@PathVariable long pid) throws ResourceNotFoundException {
		return adminpostService.searchByPostId(pid);	
	}
	

//deletes post by post Id
	@ApiOperation(value ="Deletes  Post by post Id")
	
	@ApiResponses(value= {
			@ApiResponse(code=404,message="Post not deleted"),
			@ApiResponse(code=200,message="post got deleted")
			
	})
	@DeleteMapping("admin/post/{id}")
    public List<Post> deletePost(@PathVariable long id) throws ResourceNotFoundException{
		adminpostService.deletePostById(id);
		List<Post> list=adminpostService.findAll();
		return list;
    }
	
	
//returns all posts of specific user id
	@ApiOperation(value ="Returns All Posts for a specific user id")
	
	@ApiResponses(value= {
			@ApiResponse(code=404,message="No such posts found "),
			@ApiResponse(code=200,message="posts found")
			
	})
	@GetMapping("admin/post/view/{userid}")
	public List<Post> findPostByUserId(@PathVariable long userid) throws ResourceNotFoundException {
		return adminpostService.findByUserId(userid);	
	}
	
//returns all user id's who posted posts
	@ApiOperation(value ="Returns All usersId ")
	@ApiResponses(value= {
			@ApiResponse(code=404,message="No such posts found "),
			@ApiResponse(code=200,message="posts found")
			
	})
	@GetMapping("admin/post/allusers")
	public List<Long> findAllUserId() throws ResourceNotFoundException {
		return adminpostService.findAllUserId();	
	}
}
