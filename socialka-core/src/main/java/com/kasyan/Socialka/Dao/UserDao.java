package com.kasyan.Socialka.Dao;

import java.util.List;

import com.kasyan.Socialka.Dto.Friend;
import com.kasyan.Socialka.Dto.Image;
import com.kasyan.Socialka.Dto.User;

public interface UserDao {
	
	public void addUser(User user);
	public void addImage(Image image);
	public boolean isEmailUnique(String email);
	public User getByEmail(String email);
	public User getById(int id);
	public List<User> getFriends(String email);
	public List<User> getAllUsers();
	public void addFriendship(Friend friend);
}
