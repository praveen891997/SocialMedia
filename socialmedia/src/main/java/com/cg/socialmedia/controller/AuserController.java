package com.cg.socialmedia.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.socialmedia.Myproperties;
import com.cg.socialmedia.entity.Auser;
import com.cg.socialmedia.entity.UserProfile;
import com.cg.socialmedia.exception.ResourceNotFoundException;
import com.cg.socialmedia.exception.UserAlreadyExistsException;
import com.cg.socialmedia.exception.UserNotFoundException;
import com.cg.socialmedia.repository.AuserRepository;
import com.cg.socialmedia.service.AuserService;
import com.cg.socialmedia.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class AuserController {
	private static final Logger Logger=LogManager.getLogger(AuserController.class);
	
	@Autowired
	Myproperties properties;
	@Autowired
	private AuserService userService;
	
	 @Autowired
     private AuserRepository repo;


	@PostMapping("/register")
	public Auser registerUser(@RequestBody Auser user) throws UserAlreadyExistsException, UserNotFoundException {
		try {
			Auser user1 = userService.findByEmailId(user.getEmailId());
		if(user1==null) {
			Logger.info(properties.getLog().getSuccess());
			return userService.registerUser(user);
		}else {
			Logger.error(properties.getLog().getAccept());
			throw new UserAlreadyExistsException("User Already Exists");
		}
		
		}catch(UserAlreadyExistsException e) {
			e.getMessage();
		}
		return null;
	}

	@GetMapping("/login/{email_id}/{password}")
	public String loginUser( @PathVariable(value="email_id") String emailId, @PathVariable(value="password") String password) throws UserNotFoundException {
		Auser user = userService.findByEmailId(emailId);
		String status="invalid Password";
		try {
			if(user!=null) {
				if(user.getPassword().equals(password)) {
					status="valid";
					return status;
				}else {
					return status;
				}
			}else {
				Logger.error(properties.getLog().getInvalid());
				throw new UserNotFoundException("Incorrect email Id");
			}
		}catch(UserNotFoundException e) {
			e.getMessage();
		}
		return status;
	}

	@GetMapping("/{email_id}")
	public ResponseEntity<Auser> findByEmailId(@PathVariable(value= "email_id") String emailId) throws UserNotFoundException {
		Auser user = userService.findByEmailId(emailId);
		return ResponseEntity.ok().body(user);
	}

	@PutMapping("/update/{email_id}")
	public ResponseEntity<Auser> updatePassword(@PathVariable(value = "email_id") String emailId, @RequestBody String password) throws UserNotFoundException {
		Auser u = userService.findByEmailId(emailId);
		u.setPassword(password);
		Auser updatedUser = userService.updatePassword(u);
		return ResponseEntity.ok(updatedUser);
	}
	
@ApiOperation(value ="Returns All Users")
	
	@ApiResponses(value= {
			@ApiResponse(code=404,message="No such user found"),
			@ApiResponse(code=200,message="users found")})
	@GetMapping("admin/user1")
	public List<Auser> findAllPost() throws ResourceNotFoundException {
	Logger.info(properties.getLog().getFound());
		return userService.viewAllUsers();	
		
	}


@ApiOperation(value ="Deletes  user by user Id")

@ApiResponses(value= {
		@ApiResponse(code=404,message="user not deleted"),
		@ApiResponse(code=200,message="user got deleted")
		
})
@DeleteMapping("admin/user1/{id}")
public List<Auser> deleteUser(@PathVariable long id) throws ResourceNotFoundException{
	userService.deleteUserById(id);
	List<Auser> userList=userService.findAll();
	return userList;
}
}
