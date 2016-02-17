package com.kasyan.Socialka.services;

import java.util.List;

import com.kasyan.Socialka.dto.User;

public interface FriendshipService {
	void confirmFriendship(int idOne, int idTwo);
	void addProposalBeFriend(String emailOne, int idTwo);
	List<User> getFriends(String email);
	int getFriendsStatus(String emailOne, int idTwo);
	Long getQuantityProposals(String email);
	void deleteFromFriends(String emailOne, int idTwo);
	void returnFriendship(String emailOne, int idTwo);
}
