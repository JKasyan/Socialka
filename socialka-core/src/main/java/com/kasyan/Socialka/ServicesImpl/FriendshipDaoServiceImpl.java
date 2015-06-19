package com.kasyan.Socialka.ServicesImpl;

import java.util.List;





import com.kasyan.Socialka.Dao.FriendshipDao;
import com.kasyan.Socialka.Dto.User;
import com.kasyan.Socialka.Services.FriendshipDaoService;

public class FriendshipDaoServiceImpl implements FriendshipDaoService {
	
	private FriendshipDao friendshipDao;

	public void setFriendshipDao(FriendshipDao friendshipDao) {
		this.friendshipDao = friendshipDao;
	}

	public void addProposalBeFriend(String emailOne, int idTwo) {
		friendshipDao.addProposalBeFriend(emailOne, idTwo);
	}

	public List<User> getFriends(int id) {
		return friendshipDao.getFriends(id);
	}

	public void confirmFriendship(int idOne, int idTwo) {
		friendshipDao.confirmFriendship(idOne, idTwo);
	}

	public int getFriendsStatus(String emailOne, int idTwo) {
		return friendshipDao.getFriendsStatus(emailOne, idTwo);
	}

}
