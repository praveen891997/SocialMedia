package com.cg.socialmedia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.socialmedia.entity.Post;
import com.cg.socialmedia.entity.UserProfile;
import com.cg.socialmedia.repository.PostRepo;


@Service
public class PostService {
	
	@Autowired
	private PostRepo postRepo;
	
	public Post uploadPost(Post post)
	{
		
		return postRepo.save(post);
	}
	
	public List<Post> viewAllPosts()
	{
		return postRepo.findAll();
	}
	
	public Post searchByPostId(long pid)
	{
		return postRepo.findByPostId(pid);
	}

}
