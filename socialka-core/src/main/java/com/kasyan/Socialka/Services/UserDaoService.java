package com.kasyan.Socialka.Services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.kasyan.Socialka.Dto.Image;
import com.kasyan.Socialka.Dto.User;

@Transactional
public interface UserDaoService {
	
	public void addUser(User user);
	public void addImage(Image image);
	public boolean isEmailUnique(String email);
	public User getByEmail(String email);
	public User getById(int id);
	public List<User> getFriends(String email);
}
