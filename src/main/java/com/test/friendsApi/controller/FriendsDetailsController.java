package com.test.friendsApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.test.friendsApi.dao.FriendsRepo;
import com.test.friendsApi.model.Friends;
import com.test.friendsApi.service.FriendDetailsService;


@RestController
@RequestMapping("/api/v1")
public class FriendsDetailsController {
	
	
	@Autowired
	FriendsRepo friendsRepo;
	
	@Autowired
	FriendDetailsService friendDetailsService;
	
	 
	@GetMapping("/userList")
	public ResponseEntity<List<Friends>> getUserList(){
		return ResponseEntity.ok(friendDetailsService.getUserList());
	}
	
	@GetMapping("/usersFriendList/{id}")
	public ResponseEntity<List<Friends>> getusersFriendList(@PathVariable Integer id){
		return ResponseEntity.ok(friendsRepo.findByFriendId(id));
	}
	
	@GetMapping("/usersSuggestedFriendList/{id}")
	public ResponseEntity<List<Friends>> getUsersSuggestedFriendList(@PathVariable Integer id){

		return ResponseEntity.ok(friendDetailsService.getUsersSuggestedFriendList(id));
	}
	
	@GetMapping("/usersSuggestedFriendListGeographically/{id}")
	public ResponseEntity<List<Friends>> getUsersSuggestedFriendListGeographically(@PathVariable Integer id){

		return ResponseEntity.ok(friendDetailsService.getUserSuggestedFriendListGeographically(id));
	}
	
	

}
