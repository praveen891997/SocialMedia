package com.cg.socialmedia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.socialmedia.entity.Post;
import com.cg.socialmedia.entity.UserProfile;
import com.cg.socialmedia.exception.ResourceNotFoundException;
import com.cg.socialmedia.repository.AdminUserprofileRepo;
import com.cg.socialmedia.repository.UserprofileRepo;

@Service
public class AdminUserProfileService {
	@Autowired
	private AdminUserprofileRepo userprofileRepo;
	
	
	//method to view all records of userprofile
	public List<UserProfile> viewAllUsers() throws ResourceNotFoundException
	{
		List<UserProfile> userProfile= userprofileRepo.findAll();
		if(userProfile==null || userProfile.isEmpty()) {
			throw new ResourceNotFoundException("not found");
		}
		else {
			return userProfile;
		}
	}
	
	//method to view users by userId
	public UserProfile searchByUserId(long uid) throws ResourceNotFoundException
	{
		UserProfile userProfile =userprofileRepo.findUserById(uid);
		if(userProfile==null) {
			throw new ResourceNotFoundException("not found");
		}
		else {
			return userProfile;
		}
	}
	
	//method to delete user record by id
	public Integer deleteUserById(long id) throws ResourceNotFoundException{
		UserProfile userProfile=userprofileRepo.findUserById(id);
		if(userProfile==null) {
			throw new ResourceNotFoundException("not found");
		}
		else {
			userprofileRepo.deleteById(id);
			return 1;
		}
	}
	
	//to view All user id
	public List<Long> findAllUserId() throws ResourceNotFoundException{
		List<Long> userProfileList=userprofileRepo.findAlluserprofileId();
		if(userProfileList==null || userProfileList.isEmpty()) {
			throw new ResourceNotFoundException("not found");
		}
		else {
			return userProfileList;
		}
	}
	
	
	public List<UserProfile> findAll() throws ResourceNotFoundException{
		List<UserProfile> userList=userprofileRepo.findAll();
		if(userList==null || userList.isEmpty()) {
			throw new ResourceNotFoundException("not found");
		}
		else {
			return userList;
		}
	}
	
	public UserProfile searchByUseName(String uname) throws ResourceNotFoundException
	{
		UserProfile userProfile =userprofileRepo.findUserByUsername(uname);
		if(userProfile==null) {
			throw new ResourceNotFoundException("not found");
		}
		else {
			return userProfile;
		}
	}
}
