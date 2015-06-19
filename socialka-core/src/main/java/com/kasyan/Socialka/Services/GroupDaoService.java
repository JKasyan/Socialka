package com.kasyan.Socialka.Services;

import java.util.List;

import com.kasyan.Socialka.Dto.Group;
import com.kasyan.Socialka.Dto.User;

public interface GroupDaoService {
	public void joinGroup(User user);
	public List<User> getMembers();
	public Group getGroup(String title);
}
