package com.kasyan.Socialka.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kasyan.Socialka.services.FriendshipService;

@SuppressWarnings({"ALL", "SpringJavaAutowiringInspection"})
@Controller
public class AddFriendController {
	
	@Autowired
	private FriendshipService friendshipService;
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	public void setFriendshipService(FriendshipService friendshipService) {
		this.friendshipService = friendshipService;
	}

	@RequestMapping(value="/friend/add_to_friend", method=RequestMethod.GET)
	public @ResponseBody String addProposalBeFriend(@RequestParam("queryId") String id){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String emailOne = authentication.getName();
		int idInt = Integer.valueOf(id);
		logger.debug("User with email "+emailOne+" wants to be friend with user with id "+idInt);
		friendshipService.addProposalBeFriend(emailOne, idInt);
		return "succes";
	}
	
	@RequestMapping(value="/confirm_friendship", method=RequestMethod.POST)
	public void confirmFriendship(){
		
	}

}
