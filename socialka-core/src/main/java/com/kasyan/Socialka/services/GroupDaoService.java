package com.kasyan.Socialka.services;

import java.util.List;

import com.kasyan.Socialka.dto.Group;
import com.kasyan.Socialka.dto.User;

public interface GroupDaoService {
	public void joinGroup(User user);
	public List<User> getMembers();
	public Group getGroup(String title);
}
