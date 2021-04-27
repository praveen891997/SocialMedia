package com.cg.socialmedia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.socialmedia.entity.Post;
import com.cg.socialmedia.entity.UserProfile;

@Repository

public interface UserprofileRepo extends JpaRepository<UserProfile, Long>{
	@Query(value="select *  from User_profile_details where userprofile_id=?1", nativeQuery=true)
	UserProfile findUserById(long id);
	
	@Query("select distinct u.userprofile_id from UserProfile u")
	List<Long> findAlluserprofileId();
	
	
}
