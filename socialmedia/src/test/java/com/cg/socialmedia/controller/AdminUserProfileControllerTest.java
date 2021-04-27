package com.cg.socialmedia.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.cg.socialmedia.entity.Auser;
import com.cg.socialmedia.entity.Post;
import com.cg.socialmedia.entity.UserProfile;
import com.cg.socialmedia.service.AdminPostService;
import com.cg.socialmedia.service.AdminUserProfileService;
import com.cg.socialmedia.service.AuserService;

@SpringBootTest
public class AdminUserProfileControllerTest {
	@Autowired
	private AuserService auserService;
	
	
	@Test
	void testDeleteByUserProfileId() {
		RestTemplate restTemplate = new RestTemplate();
		 restTemplate.delete("http://localhost:8080/api/admin/user1/27"); 
	}
	
	@Test
	void testDeleteByIncorrectUserProfileId() {
		RestTemplate restTemplate = new RestTemplate();
		Exception exception=assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,()->{
			restTemplate.delete("http://localhost:8080/api/admin/user1/100");
		});	
	}
}
