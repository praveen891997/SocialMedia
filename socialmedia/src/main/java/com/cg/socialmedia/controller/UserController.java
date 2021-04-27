package com.cg.socialmedia.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.socialmedia.entity.Auser;
import com.cg.socialmedia.entity.User;
import com.cg.socialmedia.repository.UserRepository;
import com.cg.socialmedia.service.UserService;



@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
@RestController
public class UserController {
	@Autowired
	private UserService userservice;
	@Autowired
	private UserRepository repo;
	@PostMapping("/user")
	public Auser createUser(@RequestBody Auser user) {
	
		return userservice.add(user);
	}
	@GetMapping("/user")
    public List<Auser> getallUser(){
    	return userservice.findall();
    }
	@GetMapping("/user/{firstName}")
	public Auser findByfirstName(@PathVariable String firstName) {
		return repo.findByFirstName(firstName);
		
	}
}
