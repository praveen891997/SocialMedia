package com.cg.socialmedia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.socialmedia.entity.Post;
import com.cg.socialmedia.entity.UserProfile;
import com.cg.socialmedia.exception.ResourceNotFoundException;
import com.cg.socialmedia.repository.UserprofileRepo;
import com.cg.socialmedia.service.AdminUserProfileService;
import com.cg.socialmedia.service.UserprofileService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin()
@RequestMapping("/api")
@Api(value="social media related Rest APIs")
public class AdminUserProfileController {
	@Autowired
	private AdminUserProfileService adminUserProfileService;
	
	@Autowired
	private UserprofileRepo userprofileRepo;
	
	@ApiOperation(value ="Returns All Users")
	
	@ApiResponses(value= {
			@ApiResponse(code=404,message="No such user found"),
			@ApiResponse(code=200,message="users found")})
	@GetMapping("admin/user")
	public List<UserProfile> findAllPost() throws ResourceNotFoundException {
		return adminUserProfileService.viewAllUsers();	
	}
	
	@ApiOperation(value ="Returns user for a specific user Id")

	@ApiResponses(value= {
	@ApiResponse(code=404,message="No such user found"),
	@ApiResponse(code=200,message="user found")
	
	})
	@GetMapping("admin/user/{uid}")
	public UserProfile findUserById(@PathVariable long uid) throws ResourceNotFoundException {
		return adminUserProfileService.searchByUserId(uid);	
	}
	
	
	@ApiOperation(value ="Deletes  user by user Id")
	
	@ApiResponses(value= {
			@ApiResponse(code=404,message="user not deleted"),
			@ApiResponse(code=200,message="user got deleted")
			
	})
	@DeleteMapping("admin/user/{id}")
    public List<UserProfile> deleteUser(@PathVariable long id) throws ResourceNotFoundException{
		adminUserProfileService.deleteUserById(id);
		List<UserProfile> userList=adminUserProfileService.findAll();
		return userList;
    }
	
	@ApiOperation(value ="Returns All usersId ")
	@ApiResponses(value= {
			@ApiResponse(code=404,message="No such users found "),
			@ApiResponse(code=200,message="users found")
			
	})
	@GetMapping("admin/user/allusers")
	public List<Long> findAllUserId() throws ResourceNotFoundException {
		return adminUserProfileService.findAllUserId();	
	}
	
	@GetMapping("admin/user/name/{uname}")
	public UserProfile findUserByUserName(@PathVariable String uname) throws ResourceNotFoundException {
		return adminUserProfileService.searchByUseName(uname);	
	}
}

