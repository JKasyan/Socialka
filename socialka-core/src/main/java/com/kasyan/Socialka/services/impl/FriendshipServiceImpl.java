package com.kasyan.Socialka.services.impl;

import java.util.List;









import com.kasyan.Socialka.dao.FriendshipDao;
import com.kasyan.Socialka.dto.User;
import com.kasyan.Socialka.services.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class FriendshipServiceImpl implements FriendshipService {

	//@Autowired
	private FriendshipDao friendshipDao;

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
