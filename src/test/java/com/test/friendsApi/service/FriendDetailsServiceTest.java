package com.test.friendsApi.service;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.friendsApi.dao.FriendsRepo;
import com.test.friendsApi.model.FriendIdentity;
import com.test.friendsApi.model.Friends;

@SpringBootTest
public class FriendDetailsServiceTest {
	
	
	@Mock 
	FriendsRepo friendsRepo;
	
	@InjectMocks
	FriendDetailsService friendDetailsService;
	


	
	
	@Test
	public void getUserListTest() {
		List<Friends> testUserList= new ArrayList<>();
		testUserList.add(new Friends(new FriendIdentity(1, 3),"Alice","Dublin"));
		testUserList.add(new Friends(new FriendIdentity(2, 3),"Bob","Dublin"));
		testUserList.add(new Friends(new FriendIdentity(3, 1),"Charlie","London"));
		testUserList.add(new Friends(new FriendIdentity(4, 2),"Davina","Belfast"));
		testUserList.add(new Friends(new FriendIdentity(5, 2),"John","Galway"));
		
		Mockito.lenient().when(friendsRepo.findAll()).thenReturn(testUserList);
		List<Friends> result =friendDetailsService.getUserList();
	
	    assertNotNull(result);
	    assertEquals(5, result.size());
	    assertEquals(1, result.stream().filter(c -> c.getName().equals("Alice")).count());
	    assertEquals(1, result.stream().filter(c -> c.getName().equals("Bob")).count());
	    assertEquals(1, result.stream().filter(c -> c.getName().equals("Charlie")).count());
	    assertEquals(1, result.stream().filter(c -> c.getName().equals("Davina")).count());
	    assertEquals(1, result.stream().filter(c -> c.getName().equals("John")).count());

	}
	
	
	

}
