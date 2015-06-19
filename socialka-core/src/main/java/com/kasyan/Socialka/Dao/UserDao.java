package com.kasyan.Socialka.Dao;

import java.util.List;
import com.kasyan.Socialka.Dto.User;
import com.kasyan.Socialka.Exceptions.UserNotFoundException;

public interface UserDao {
	
	public void addUser(User user);
	public User getByEmail(String email);
	public User getById(int id) throws UserNotFoundException;
	public List<User> getAllUsers();
	/*
	public void addFriendship(Friend friend);
	public void addProposalBeFriend(ProposalBeFriend proposal);
	public List<User> getFriends(String email);
	public void addImage(Image image);
	*/
}
