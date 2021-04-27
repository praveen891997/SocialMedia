package com.cg.socialmedia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.socialmedia.entity.Post;
import com.cg.socialmedia.exception.ResourceNotFoundException;
import com.cg.socialmedia.repository.AdminPostRepo;
import com.cg.socialmedia.repository.PostRepo;

@Service
public class AdminPostService {
	@Autowired
	private AdminPostRepo postRepo;
	
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
			throw new ResourceNotFoundException("not found");
		}
		else {
			return post;
		}
	}
	
	//to view posts by user id
		public List<Post> findByUserId(long userprofile_id) throws ResourceNotFoundException{
			List<Post> postList=postRepo.findByuserprofileId(userprofile_id);
			if(postList==null || postList.isEmpty()) {
				throw new ResourceNotFoundException("not found");
			}
			else {
				return postList;
			}
		}
		
		//to view All user id
				public List<Long> findAllUserId() throws ResourceNotFoundException{
					List<Long> postList=postRepo.findAlluserprofileId();
					if(postList==null || postList.isEmpty()) {
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
			throw new ResourceNotFoundException("not found");
		}
		else {
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
