package com.cg.socialmedia.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.socialmedia.entity.Auser;
import com.cg.socialmedia.entity.User;

public interface UserRepository extends JpaRepository<Auser, Long>{
	Auser findByFirstName(String firstName);
	

}

