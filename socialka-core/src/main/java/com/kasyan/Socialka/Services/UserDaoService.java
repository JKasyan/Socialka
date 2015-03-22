package com.kasyan.Socialka.Services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.kasyan.Socialka.Dto.Friend;
import com.kasyan.Socialka.Dto.Image;
import com.kasyan.Socialka.Dto.User;
import com.kasyan.Socialka.Exceptions.UserNotFoundException;

@Transactional
public interface UserDaoService {
	
	public void addUser(User user);
	public void addImage(Image image);
	public boolean isUserExist(int id);
	public User getByEmail(String email);
	public User getById(int id) throws UserNotFoundException;
	public List<User> getFriends(String email);
	public List<User> getAllUsers();
	public void addFriendship(Friend friend);
}
