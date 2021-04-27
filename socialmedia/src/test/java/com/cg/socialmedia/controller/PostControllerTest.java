package com.cg.socialmedia.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.TemporalType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.cg.socialmedia.entity.Post;
import com.cg.socialmedia.entity.UserProfile;
import com.cg.socialmedia.service.AdminPostService;
import com.cg.socialmedia.service.PostService;


@SpringBootTest
public class PostControllerTest {

	@Autowired
	private PostService postService;
	
//Test method for successful addition of post
@Test
	public void addPostSuccess() {
		
		RestTemplate restTemplate = new RestTemplate();
		UserProfile userProfile=new UserProfile((long) 71,"student","female", LocalDate.of(2021, 02, 15),"www","java");
		Post post = new Post(54,"java",7,LocalDate.of(2021, 03, 15),"Java",userProfile);
		Post responseEntityElection = restTemplate.postForObject("http://localhost:8080/api/post", post, Post.class);
		assertNotNull(responseEntityElection);
		
}
	
	
/*	@Test
	public void addPostFailed() {
		
		RestTemplate restTemplate = new RestTemplate();
		UserProfile userProfile=new UserProfile((long) 20,"","female", LocalDate.of(2021, 02, 15),"www","java");
		Post post = new Post(57,"",7,LocalDate.of(2021, 03, 15),"Java",userProfile);
		Exception exception=assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,()->{
			restTemplate.postForObject("http://localhost:8080/api/post", post, Post.class);
		});
		
	}*/

@Test
void testfindByPostId() {
	RestTemplate restTemplate = new RestTemplate();
	Post post= restTemplate.getForObject("http://localhost:8080/api/post/35",Post.class);
	assertNotNull(post);
}

@Test
void testfindByIncorrectPostId() {
	RestTemplate restTemplate = new RestTemplate();
	Exception exception=assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,()->{
		restTemplate.getForObject("http://localhost:8080/api/post/90",Post.class);
	});	
}

@Test
void testDeleteByPostId() {
	RestTemplate restTemplate = new RestTemplate();
	 restTemplate.delete("http://localhost:8080/api/post/37"); 
}

@Test
void testDeleteByIncorrectPostId() {
	RestTemplate restTemplate = new RestTemplate();
	Exception exception=assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,()->{
		restTemplate.delete("http://localhost:8080/api/post/37");
	});	
}
}
