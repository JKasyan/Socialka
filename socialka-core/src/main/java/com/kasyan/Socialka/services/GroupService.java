package com.kasyan.Socialka.services;

import java.util.List;

import com.kasyan.Socialka.dto.Group;
import com.kasyan.Socialka.dto.User;

public interface GroupService {
	void joinGroup(User user);
	List<User> getMembers();
	Group getGroup(String title);
}
