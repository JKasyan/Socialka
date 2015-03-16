package com.kasyan.Socialka.Services.Impl;


import com.kasyan.Socialka.Dao.UserDao;
import com.kasyan.Socialka.Dto.Image;
import com.kasyan.Socialka.Dto.User;
import com.kasyan.Socialka.Services.UserDaoService;

public class UserDaoServiceImpl implements UserDaoService {
	
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public boolean isEmailUnique(String email) {
		return userDao.isEmailUnique(email);
	}

	@Override
	public User getByEmail(String email) {
		return userDao.getByEmail(email);
	}

	@Override
	public void addImage(Image image) {
		userDao.addImage(image);
	}

	@Override
	public User getById(int id) {
		return userDao.getById(id);
	}
}