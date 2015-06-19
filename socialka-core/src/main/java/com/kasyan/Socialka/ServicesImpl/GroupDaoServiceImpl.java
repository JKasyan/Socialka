package com.kasyan.Socialka.ServicesImpl;

import java.util.List;

import com.kasyan.Socialka.Dao.GroupDao;
import com.kasyan.Socialka.Dto.Group;
import com.kasyan.Socialka.Dto.User;
import com.kasyan.Socialka.Services.GroupDaoService;

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
