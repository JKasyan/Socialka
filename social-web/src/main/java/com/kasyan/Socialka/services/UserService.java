package com.kasyan.Socialka.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.kasyan.Socialka.dto.User;
import com.kasyan.Socialka.exceptions.UserNotFoundException;

@Transactional
public interface UserService {
	
	void addUser(User user);
	User getByEmail(String email);
	User getById(int id) throws UserNotFoundException;
	List<User> getAllUsers();
	/*
	public void addImage(Image image);
	public List<User> getFriends(String email);
	public void addFriendship(Friend friend);
	public void addProposalBeFriend(ProposalBeFriend proposal);
	*/
}
