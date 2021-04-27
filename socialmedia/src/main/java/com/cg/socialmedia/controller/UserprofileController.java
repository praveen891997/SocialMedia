package com.cg.socialmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.socialmedia.entity.Post;
import com.cg.socialmedia.entity.UserProfile;
import com.cg.socialmedia.repository.UserprofileRepo;
import com.cg.socialmedia.service.UserprofileService;

@RestController
@CrossOrigin()
@RequestMapping("/api")

public class UserprofileController {
	
	
	@Autowired
	private UserprofileService userprofileService;
	
	@Autowired
	private UserprofileRepo userprofileRepo;
	
	
	@PostMapping("/userprofile")
	public UserProfile createProfile(@RequestBody UserProfile u) {
		return userprofileService.uploadUser(u);
	}
	@GetMapping("/userprofiles")
	public List<UserProfile> viewAllUserProfiles(){
		return userprofileRepo.findAll();
	}


}
