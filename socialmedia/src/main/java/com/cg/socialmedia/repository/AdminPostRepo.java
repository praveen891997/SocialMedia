package com.cg.socialmedia.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.socialmedia.entity.Post;
import com.cg.socialmedia.entity.UserProfile;

@Repository
public interface AdminPostRepo extends JpaRepository<Post, Long>{
	@Query(value="select * from post_details where post_id=?1", nativeQuery=true)
	Post findByPostId(long pid);
	
	@Query(value="select * from post_details where userprofile_id=?1", nativeQuery=true)
	//@Query("select new com.cg.socialmedia.entity.Post(p.post_id,p.post_content, p.post_likes, p.postedOn, p.title,p.userProfile) from Post p where p.userProfile.userprofile_id=?1")
	List<Post> findByuserprofileId(long userprofile_id);
	
	@Query("select distinct p.userProfile.userprofile_id from Post p")
		List<Long> findAlluserprofileId();
}



