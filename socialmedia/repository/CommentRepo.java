package com.cg.socialmedia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.socialmedia.entity.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long>{
	@Query(value="select * from comment_details where comment_id=?1", nativeQuery=true)
	Comment findByCommentID(long id);

	@Query(value="select * from comment_details where post_id=?1", nativeQuery=true)
	List<Comment> findByPostID(long id);
	
	@Query(value="select * from comment_details where userprofile_id=?1", nativeQuery=true)
	List<Comment> findByUserID(long id);
	
	@Query("select distinct c.userProfile.userprofile_id from Comment c")
	List<Long> findAlluserprofileId();
}
