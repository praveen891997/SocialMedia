package com.cg.socialmedia.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.cg.socialmedia.entity.Post;
import com.cg.socialmedia.service.AdminPostService;





@SpringBootTest
public class AdminPostControllerTest {
	@Autowired
	private AdminPostService adminPostService;
	
	@Test
	void testfindByPostId() {
		RestTemplate restTemplate = new RestTemplate();
		Post post= restTemplate.getForObject("http://localhost:8080/api/admin/post/21",Post.class);
		assertNotNull(post);
	}
	
	@Test
	void testfindByIncorrectPostId() {
		RestTemplate restTemplate = new RestTemplate();
		Exception exception=assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,()->{
			restTemplate.getForObject("http://localhost:8080/api/admin/post/90",Post.class);
		});	
	}
	
	
	@Test
	void testfindByUserId() {
		RestTemplate restTemplate = new RestTemplate();
		Post post[]= restTemplate.getForObject("http://localhost:8080/api/admin/post/view/1",Post[].class);
		assertNotNull(post);
	}
	
	@Test
	void testfindByIncorrectUserId() {
		RestTemplate restTemplate = new RestTemplate();
		Exception exception=assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,()->{
			restTemplate.getForObject("http://localhost:8080/api/admin/post/90",Post.class);
		});	
	}
	
	@Test
	void testDeleteByPostId() {
		RestTemplate restTemplate = new RestTemplate();
		 restTemplate.delete("http://localhost:8080/api/admin/post/23"); 
	}
	
	@Test
	void testDeleteByIncorrectPostId() {
		RestTemplate restTemplate = new RestTemplate();
		Exception exception=assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,()->{
			restTemplate.delete("http://localhost:8080/api/admin/post/100");
		});	
	}
}
