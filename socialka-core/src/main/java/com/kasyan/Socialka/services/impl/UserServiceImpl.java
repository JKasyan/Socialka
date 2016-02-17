package com.kasyan.Socialka.services.impl;

import java.util.List;

import com.kasyan.Socialka.dao.UserDao;
import com.kasyan.Socialka.dto.User;
import com.kasyan.Socialka.exceptions.UserNotFoundException;
import com.kasyan.Socialka.services.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	public User getByEmail(String email) {
		return userDao.getByEmail(email);
	}
	
	public User getById(int id) throws UserNotFoundException{
		return userDao.getById(id);
	}
	
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
}
