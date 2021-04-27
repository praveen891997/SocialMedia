package com.cg.socialmedia.controller;

import java.util.List;

import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.socialmedia.Myproperties;
import com.cg.socialmedia.entity.Auser;
import com.cg.socialmedia.entity.Friends;
import com.cg.socialmedia.entity.Status;
import com.cg.socialmedia.entity.User;
import com.cg.socialmedia.exception.FriendException;
import com.cg.socialmedia.repository.FriendRepository;
import com.cg.socialmedia.repository.UserRepository;
import com.cg.socialmedia.service.FriendServiceimp;



@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
@RestController
public class FriendsController {
	private static final Logger Logger=LogManager.getLogger(FriendsController.class);
	@Autowired
	Myproperties properties;
	@Autowired
	private FriendServiceimp friendservice;
	@Autowired
	private FriendRepository repo;
	@Autowired
	private UserRepository repo1;
	@PostMapping(value="/")
          public Friends Requstfriend(@RequestBody Friends friend) {
        	  return repo.save(friend);
        	  
          }
	//Add request
	@ResponseStatus(value = HttpStatus.OK)
		@PostMapping(value="/friend/{name}/{name2}")
		public ResponseEntity<?> Request(@PathVariable String name,@PathVariable String name2,@RequestBody Friends friend) {
		     Auser user=repo1.findByFirstName(name);
		     Auser user2=repo1.findByFirstName(name2);
			Friends fri=friendservice.FindByuserid(user.getUserId(), user2.getUserId());
			Friends fri2=friendservice.FindByuserid(user2.getUserId(), user.getUserId());
			if (fri==null && fri2==null) {
				friend.setStatus(Status.REQUEST);
				friend.setActiveid(user.getUserId());
				friend.setUser(user);
				friend.setUserid2(user2);
			 Friends fr2=friendservice.add(friend);
			 return new ResponseEntity<Friends>(fr2,HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Boolean>(false,HttpStatus.OK);
			}
			
		}
	//Accept Request
	@PutMapping(value="/friend/{user}/{user2}")
   public Integer acceptRequest (@PathVariable Long user,@PathVariable Long user2) {
	     return friendservice.AcceptRequest(user, user2);
	   
   }
	//friend list
    @GetMapping(value="/friend/{user}")
       public ResponseEntity< ?> friendlist(@PathVariable Long user){
         List<Friends>fri=friendservice.listFriend(user);
         List<Auser>user2= fri.stream().filter(p->p.getUserid2().getUserId() != user).map(p->p.getUserid2()).collect(Collectors.toList());
         List<Auser>user1= fri.stream().filter(p->p.getUser().getUserId() !=user).map(p->p.getUser()).collect(Collectors.toList());
         user1.addAll(user2);
         if(user1.isEmpty()) {
        	 Logger.error(properties.getLog().getNofriend());
             return new ResponseEntity<String>("NO FRIEND ADDED",HttpStatus.OK);
         }
         Logger.info(properties.getLog().getFriend());
            return new ResponseEntity<List<Auser>>(user1,HttpStatus.OK);
        }
	//Status by user                   
	@GetMapping(value="friend/{user}/{userid}")
   public ResponseEntity<Friends> findByUser(@PathVariable Long user,@PathVariable Long userid) {
		Friends friend =friendservice.FindByuserid(user, userid);
		if(friend==null) {
			return new ResponseEntity<Friends>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Friends>(friend,HttpStatus.OK);
	}
//	//ListRequests
//	@GetMapping(value="friend1/{user}")
//	public ResponseEntity<?> ListRequests(@PathVariable Long user){
//		List<Friends> fri=friendservice.ListRequest(user);
//		List<User> username=fri.stream().map(p->p.getUser()).collect(Collectors.toList());
//		if (username.isEmpty()) {
//
//		  return new ResponseEntity<String>("NO REQUEST FOUND",HttpStatus.OK);  
//		}
//		else {
//		return new ResponseEntity<List<User>> (username,HttpStatus.OK);}
//	}
	//ListRequests
		@GetMapping(value="friend1/{user}")
		public ResponseEntity<?> ListRequests(@PathVariable Long user){
			List<Friends> fri=friendservice.ListRequest(user);
			
			if (fri.isEmpty()) {

			  return new ResponseEntity<String>("NO REQUEST FOUND",HttpStatus.OK);  
			}
			else {
			return new ResponseEntity<List<Friends>> (fri,HttpStatus.OK);}
		}
	//deleteRequest
	@DeleteMapping(value="friend/{user}/{user1}")
	public Boolean DeleteRequest(@PathVariable Long user , @PathVariable Long user1) throws FriendException{
		Friends friend=friendservice.FindByuserid(user, user1);
		
		if (friend == null) {
			return false;
		}
		else {
			friendservice.deleteRequest(friend);
			return true;
		}
		
		
	}
}
