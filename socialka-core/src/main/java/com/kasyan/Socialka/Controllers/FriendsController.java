package com.kasyan.Socialka.Controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kasyan.Socialka.Dto.User;
import com.kasyan.Socialka.Services.FriendshipDaoService;

@Controller
public class FriendsController {
	
	@Autowired
	private FriendshipDaoService friendshipDaoService;
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	public void setFriendshipDaoService(FriendshipDaoService friendshipDaoService) {
		this.friendshipDaoService = friendshipDaoService;
	}

	@RequestMapping(value="/my_friends", method=RequestMethod.GET)
	public String getMyFriends(HttpServletRequest req, Model model){
		/*
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		logger.debug("Email: "+email);
		if(email!="anonymousUser" && email!=null){
			List<User> friends = friendDaoService.getFriends(email);
			model.addAttribute("friends", friends);
			return "my_friends";
		}
		return "redirect:/index.jsp";
		*/
		return null;
	}

}
