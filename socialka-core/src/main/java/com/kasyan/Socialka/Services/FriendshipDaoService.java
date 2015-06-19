package com.kasyan.Socialka.Services;

import java.util.List;

import com.kasyan.Socialka.Dto.User;

public interface FriendshipDaoService {
	public void confirmFriendship(int idOne, int idTwo);
	public void addProposalBeFriend(String emailOne, int idTwo);
	public List<User> getFriends(int id);
	public int getFriendsStatus(String emailOne, int idTwo);
}
