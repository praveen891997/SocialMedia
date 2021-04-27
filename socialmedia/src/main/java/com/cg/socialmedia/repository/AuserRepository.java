package com.cg.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.socialmedia.entity.Auser;
import com.cg.socialmedia.entity.UserProfile;

@Repository
public interface AuserRepository extends JpaRepository<Auser, Long>{

	public Auser findByEmailId(String emailId);

	public Auser findByUsername(String username);
	
	Auser findByFirstName(String firstName);
	
	@Query(value="select *  from ausers where user_id=?1", nativeQuery=true)
	Auser findUserById(long id);
	
}
