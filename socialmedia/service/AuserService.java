package com.cg.socialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cg.socialmedia.entity.Auser;
import com.cg.socialmedia.exception.UserAlreadyExistsException;
import com.cg.socialmedia.exception.UserNotFoundException;
import com.cg.socialmedia.repository.AuserRepository;

@Service
public class AuserService{
	
	@Autowired
	private AuserRepository userRepo;
	

	public AuserRepository getUserRepo() {
		return userRepo;
	}

	public void setUserRepo(AuserRepository userRepo) {
		this.userRepo = userRepo;
	}


	public Auser registerUser(Auser user) throws UserAlreadyExistsException{
		return userRepo.save(user);
	}

	public Auser updatePassword(Auser user) throws UserNotFoundException {
		return userRepo.save(user);
	}

	public Auser findByEmailId(String emailId) throws UserNotFoundException {
		return userRepo.findByEmailId(emailId);
	}


}