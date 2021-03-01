package com.test.friendsApi.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.friendsApi.dao.FriendsRepo;
import com.test.friendsApi.model.Friends;

import one.util.streamex.StreamEx;

@Service
public class FriendDetailsService {
	
	@Autowired
	FriendsRepo friendsRepo;
	
	public List<Friends> getUserList() {
		  List<Friends> userList=new ArrayList<>();
		
		  friendsRepo.findAll().stream()
		 							.filter(entry ->  userList.stream().noneMatch(inputMap ->
		 				             entry.getId().getuserId().equals(inputMap.getId().getuserId())))
		 							.forEach( entry -> {userList.add(entry);});

       return userList;

	}

	
	public List<Friends> getUserSuggestedFriendListGeographically(Integer id){
		
		return getUsersSuggestedFriendList(id).parallelStream()
												.sorted(Comparator.comparing(Friends :: getCity))
												.collect(Collectors.toList());
		
	}

	public List<Friends> getUsersSuggestedFriendList(Integer id) {
     
		List<Friends> friendsList= friendsRepo.findByFriendId(id); 
		List<Friends> suggestedFriendsList=new ArrayList<>();
		
		 friendsList.stream()
		.forEach(entry -> suggestedFriendsList.addAll(getSuggestedFriendList(entry.getId().getuserId())));	
		 	 
		 return StreamEx.of(suggestedFriendsList.parallelStream().filter(searchData ->
		 friendsList.parallelStream().noneMatch(inputMap ->
             searchData.getId().getuserId().equals(inputMap.getId().getuserId())))
				 .filter(searchData -> !searchData.getId().getuserId().equals(id) )
				 .distinct()
				 .collect(Collectors.toList())).distinct(Friends::getName).toList();

	}

	private List<Friends> getSuggestedFriendList(Integer friendId) {
		
		return friendsRepo.findByFriendId(friendId);
	}


	


}
