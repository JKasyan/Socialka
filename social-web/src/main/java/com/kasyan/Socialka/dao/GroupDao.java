package com.kasyan.Socialka.dao;

import java.util.List;

import com.kasyan.Socialka.dto.Group;
import com.kasyan.Socialka.dto.User;

public interface GroupDao {
	public void joinGroup(User user);
	public List<User> getMembers();
	public Group getGroup(String title);
}
