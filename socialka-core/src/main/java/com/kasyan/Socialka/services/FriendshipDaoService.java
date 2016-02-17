package com.kasyan.Socialka.services;

import java.util.List;

import com.kasyan.Socialka.dto.User;

public interface FriendshipDaoService {
	void confirmFriendship(int idOne, int idTwo);
	public void addProposalBeFriend(String emailOne, int idTwo);
	public List<User> getFriends(String email);
	public int getFriendsStatus(String emailOne, int idTwo);
	public Long getQuantityProposals(String email);
	public void deleteFromFriends(String emailOne, int idTwo);
	public void returnFriendship(String emailOne, int idTwo);
}
