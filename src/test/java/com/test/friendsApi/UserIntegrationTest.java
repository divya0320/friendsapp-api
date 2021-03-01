package com.test.friendsApi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.friendsApi.dao.FriendsRepo;
import com.test.friendsApi.model.FriendIdentity;
import com.test.friendsApi.model.Friends;
import com.test.friendsApi.service.FriendDetailsService;

@SpringBootTest
public class UserIntegrationTest {
	
	@Autowired
	FriendDetailsService friendDetailsService;

	@Test
	public void getUserListTest() {
		
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
