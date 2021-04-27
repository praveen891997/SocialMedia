package com.cg.socialmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.socialmedia.entity.Auser;
import com.cg.socialmedia.exception.UserAlreadyExistsException;
import com.cg.socialmedia.exception.UserNotFoundException;
import com.cg.socialmedia.repository.AuserRepository;
import com.cg.socialmedia.service.AuserService;




@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class AuserController {

	@Autowired
	private AuserService userService;
    @Autowired
     private AuserRepository repo;

	@PostMapping("/register")
	public Auser registerUser(@RequestBody Auser user) throws UserAlreadyExistsException, UserNotFoundException {
		try {
			Auser user1 = userService.findByEmailId(user.getEmailId());
		if(user1==null) {
			return userService.registerUser(user);
		}else {
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
	@GetMapping("/user/{firstName}")
	public Auser findByfirstName(@PathVariable String firstName) {
		return repo.findByFirstName(firstName);
		
	}
}
