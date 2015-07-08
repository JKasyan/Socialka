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

	public List<User> getFriends(String email) {
		return friendshipDao.getFriends(email);
	}

	public void confirmFriendship(int idOne, int idTwo) {
		friendshipDao.confirmFriendship(idOne, idTwo);
	}

	public int getFriendsStatus(String emailOne, int idTwo) {
		return friendshipDao.getFriendsStatus(emailOne, idTwo);
	}

	public Long getQuantityProposals(String email) {
		return friendshipDao.getQuantityProposals(email);
	}

	public void deleteFromFriends(String emailOne, int idTwo) {
		friendshipDao.deleteFromFriends(emailOne, idTwo);
	}

	public void returnFriendship(String emailOne, int idTwo) {
		friendshipDao.changeFriendshipStatus(emailOne, idTwo);
	}

}
