package com.cg.socialmedia.repository;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;





import com.cg.socialmedia.entity.Friends;
import com.cg.socialmedia.util.QueryUtil;

public interface FriendRepository extends JpaRepository<Friends, Long>{
	@Modifying
	@Transactional
	@Query(value=QueryUtil.ACCEPT_FRIEND,nativeQuery=true)
	Integer acceptRequest(Long userid,Long userid2);
	@Query(value=QueryUtil.FRIEND_LIST,nativeQuery=true)
	List<Friends> friendList(Long user);
	@Query(value=QueryUtil.FIND_USERID,nativeQuery=true)
    Friends findbyuserid(Long user,Long user2);
	@Query(value=QueryUtil.REQUEST_LIST,nativeQuery=true)
	List<Friends> RequestList(Long user);
	}   