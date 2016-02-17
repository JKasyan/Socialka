package com.kasyan.Socialka.services.impl;

import java.util.List;

import com.kasyan.Socialka.dao.GroupDao;
import com.kasyan.Socialka.dto.Group;
import com.kasyan.Socialka.dto.User;
import com.kasyan.Socialka.services.GroupDaoService;

public class GroupDaoServiceImpl implements GroupDaoService {
	
	private GroupDao groupDao;

	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}

	public void joinGroup(User user) {
		groupDao.joinGroup(user);
	}

	public List<User> getMembers() {
		return groupDao.getMembers();
	}

	public Group getGroup(String title) {
		return groupDao.getGroup(title);
	}

}
