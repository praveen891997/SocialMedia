package com.cg.socialmedia.service;

import java.util.List;

import com.cg.socialmedia.entity.Auser;
import com.cg.socialmedia.entity.User;




public interface UserService {
	public Auser add(Auser user);
	public List<Auser> findall();

}
