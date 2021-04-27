package com.cg.socialmedia.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.socialmedia.entity.Auser;
import com.cg.socialmedia.entity.User;
import com.cg.socialmedia.repository.UserRepository;


@Service
@Transactional
public class UserServiceImp implements UserService{
	@Autowired
	private UserRepository userdao;
	

	@Override
	public Auser add(Auser user) {
		
		return userdao.save(user);
	}

	@Override
	public List<Auser> findall() {
		
		return userdao.findAll();
	}

}
