package com.test.friendsApi.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.friendsApi.model.FriendIdentity;
import com.test.friendsApi.model.Friends;


public interface FriendsRepo extends JpaRepository<Friends, FriendIdentity>{

	@Query("from Friends where friend_id=?1")
	List<Friends> findByFriendId(Integer id);
	/*
	 * @Query("from FRIENDS where friend_id=?1 and friend_id<>?2") List<Friends>
	 * findSuggestedFriendsByUserId(Integer id,Integer fid);
	 */
	@Query("from Friends where user_id=?1")
	List<Friends> findDetailsByUserId(Integer userId);
}
