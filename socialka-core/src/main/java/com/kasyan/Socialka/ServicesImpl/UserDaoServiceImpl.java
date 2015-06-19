package com.kasyan.Socialka.ServicesImpl;

import java.util.List;

import com.kasyan.Socialka.Dao.UserDao;
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
