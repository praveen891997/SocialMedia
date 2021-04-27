package com.cg.socialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.socialmedia.entity.UserProfile;
import com.cg.socialmedia.repository.UserprofileRepo;

@Service
public class UserprofileService {
	@Autowired
	private UserprofileRepo userprofileRepo;
	
	
	public UserProfile uploadUser(UserProfile user)
	{
		return userprofileRepo.save(user);
	}
	

}
