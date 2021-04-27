package com.cg.socialmedia.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.socialmedia.Myproperties;
import com.cg.socialmedia.entity.Post;
import com.cg.socialmedia.exception.ResourceNotFoundException;
import com.cg.socialmedia.repository.AdminPostRepo;
import com.cg.socialmedia.repository.PostRepo;

@Service
public class AdminPostService {
	private static final Logger Logger=LogManager.getLogger(AdminPostService.class);
	@Autowired
	private AdminPostRepo postRepo;
	
	@Autowired
	Myproperties properties;
	
	//to view all records of post
	public List<Post> viewAllPosts() throws ResourceNotFoundException
	{
		List<Post> postList= postRepo.findAll();
		if(postList==null || postList.isEmpty()) {
			throw new ResourceNotFoundException("not found");
		}
		else {
			return postList;
		}
	}
	
	//to view post by post id
	public Post searchByPostId(long pid) throws ResourceNotFoundException
	{
		Post post =postRepo.findByPostId(pid);
		if(post==null) {
			Logger.error("post for post id "+pid+ properties.getLog().getFail());
			throw new ResourceNotFoundException("not found");
		}
		else {
			Logger.info("post for post id "+pid+" "+ properties.getLog().getPass()+ post);
			return post;
		}
	}
	
	//to view posts by user id
		public List<Post> findByUserId(long userprofile_id) throws ResourceNotFoundException{
			List<Post> postList=postRepo.findByuserprofileId(userprofile_id);
			if(postList==null || postList.isEmpty()) {
				Logger.error("post for user id "+userprofile_id+ properties.getLog().getFail());
				throw new ResourceNotFoundException("not found");
			}
			else {
				Logger.info("post for user id "+userprofile_id+" "+ properties.getLog().getPass()+ postList);
				return postList;
			}
		}
		
		//to view All user id
				public List<Long> findAllUserId() throws ResourceNotFoundException{
					List<Long> postList=postRepo.findAlluserprofileId();
					if(postList==null || postList.isEmpty()) {
						Logger.error("user id's "+ properties.getLog().getFail());
						throw new ResourceNotFoundException("not found");
					}
					else {
						return postList;
					}
				}
		
	
	//to delete post by post id
	public Integer deletePostById(long id) throws ResourceNotFoundException{
		Post post=postRepo.findByPostId(id);
		if(post==null) {
			Logger.error("posts for post id "+id+ properties.getLog().getFail());
			throw new ResourceNotFoundException("not found");
		}
		else {
			Logger.info("post deleted "+id+" "+ post);
			postRepo.deleteById(id);
			return 1;
		}
	}
	
	public List<Post> findAll() throws ResourceNotFoundException{
		List<Post> postList=postRepo.findAll();
		if(postList==null || postList.isEmpty()) {
			throw new ResourceNotFoundException("not found");
		}
		else {
			return postList;
		}
	}
	
}
