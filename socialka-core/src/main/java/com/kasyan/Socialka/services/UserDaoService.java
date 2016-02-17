package com.kasyan.Socialka.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.kasyan.Socialka.dto.User;
import com.kasyan.Socialka.exceptions.UserNotFoundException;

@Transactional
public interface UserDaoService {
	
	public void addUser(User user);
	public User getByEmail(String email);
	public User getById(int id) throws UserNotFoundException;
	public List<User> getAllUsers();
	/*
	public void addImage(Image image);
	public List<User> getFriends(String email);
	public void addFriendship(Friend friend);
	public void addProposalBeFriend(ProposalBeFriend proposal);
	*/
}
