package com.cg.socialmedia.controller;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.cg.socialmedia.entity.Comment;
import com.cg.socialmedia.entity.Post;
import com.cg.socialmedia.service.AdminCommentService;
import com.cg.socialmedia.service.AdminPostService;





@SpringBootTest
public class AdminCommentControllerTest {
	@Autowired
	private AdminCommentService adminCommentService;
	
	@Test
	void testfindByCommentId() {
		RestTemplate restTemplate = new RestTemplate();
		Comment comment= restTemplate.getForObject("http://localhost:8080/api/admin/comment/1",Comment.class);
		assertNotNull(comment);
	}

	@Test
	void testfindByIncorrectCommentId() {
		RestTemplate restTemplate = new RestTemplate();
		Exception exception=assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,()->{
		restTemplate.getForObject("http://localhost:8080/api/admin/comment/70",Comment.class);
		});
}

	
	@Test
	void testfindByPostId() {
		RestTemplate restTemplate = new RestTemplate();
		Comment comment[]= restTemplate.getForObject("http://localhost:8080/api/admin/comment/post/18",Comment[].class);
		assertNotNull(comment);
	}
	
	@Test
	void testfindByIncorrectPostId() {
		RestTemplate restTemplate = new RestTemplate();
		Exception exception=assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,()->{
			restTemplate.getForObject("http://localhost:8080/api/admin/comment/post/90",Comment.class);
		});	
	}
	
	@Test
	void testfindByUserId() {
		RestTemplate restTemplate = new RestTemplate();
		Comment comment[]= restTemplate.getForObject("http://localhost:8080/api/admin/comment/user/9",Comment[].class);
		assertNotNull(comment);
	}
	
	@Test
	void testfindByIncorrectUserId() {
		RestTemplate restTemplate = new RestTemplate();
		Exception exception=assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,()->{
			restTemplate.getForObject("http://localhost:8080/api/admin/comment/user/90",Comment.class);
		});	
	}
	
	@Test
	void testDeleteByCommentId() {
		RestTemplate restTemplate = new RestTemplate();
		 restTemplate.delete("http://localhost:8080/api/admin/comment/3"); 
	}
	
	@Test
	void testDeleteByIncorrectCommentId() {
		RestTemplate restTemplate = new RestTemplate();
		Exception exception=assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,()->{
			restTemplate.delete("http://localhost:8080/api/admin/comment/380");
		});	
	}
}













