package com.cg.socialmedia.service;

import java.util.List;

import java.util.Optional;

import com.cg.socialmedia.entity.Friends;
import com.cg.socialmedia.exception.FriendException;



public interface FriendsService {
	//Add friends
	public Friends add(Friends friends);
	//status friend
	public Friends FindByuserid(Long user,Long user1) throws FriendException;
	//accept request
	public Integer AcceptRequest(Long user,Long user1);
	//List Request
    public List<Friends> ListRequest(Long user) ;
    //Delete Request
    public void deleteRequest(Friends friend);
     //friendlist
     public List<Friends> listFriend(Long user);
}
