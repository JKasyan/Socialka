package com.kasyan.Socialka.ServicesImpl;

import java.util.List;

import com.kasyan.Socialka.Dao.UserDao;
import com.kasyan.Socialka.Dto.Friend;
import com.kasyan.Socialka.Dto.Image;
import com.kasyan.Socialka.Dto.User;
import com.kasyan.Socialka.Exceptions.UserNotFoundException;
import com.kasyan.Socialka.Services.UserDaoService;

public class UserDaoServiceImpl implements UserDaoService {
	
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
	public void addUser(User user) {
		userDao.addUser(user);
	}

	
	public boolean isUserExist(int id) {
		return userDao.isUserExist(id);
	}

	
	public User getByEmail(String email) {
		return userDao.getByEmail(email);
	}

	
	public void addImage(Image image) {
		userDao.addImage(image);
	}

	
	public User getById(int id) throws UserNotFoundException{
		return userDao.getById(id);
	}

	
	public List<User> getFriends(String email) {
		return userDao.getFriends(email);
	}

	
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	
	public void addFriendship(Friend friend) {
		userDao.addFriendship(friend);
	}
}
