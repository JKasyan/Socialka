package com.kasyan.Socialka.dao;

import java.util.List;







import com.kasyan.Socialka.dto.Friendship;
import com.kasyan.Socialka.dto.User;

public interface FriendshipDao {
	public void confirmFriendship(int idOne, int idTwo);//
	public void addProposalBeFriend(String emailOne, int idTwo);
	public List<User> getFriends(String email);
	public int getFriendsStatus(String emailOne, int idTwo);
	public Long getQuantityProposals(String email);
	public void deleteFromFriends(String emailOne, int idTwo);
	public void changeFriendshipStatus(String emailOne, int idTwo);
	public void update(Friendship fr);
}
