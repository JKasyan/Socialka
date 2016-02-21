package com.kasyan.Socialka.controllers;

import com.kasyan.Socialka.dto.User;
import com.kasyan.Socialka.exceptions.UserNotFoundException;
import com.kasyan.Socialka.services.FriendshipService;
import com.kasyan.Socialka.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@SuppressWarnings("ALL")
@Controller
@RequestMapping("/friend")
public class PageController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private FriendshipService friendshipService;
	private final Logger logger = Logger.getLogger(PageController.class);
	
	@Transactional
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView showFriendProfile(@PathVariable int id)
			throws UserNotFoundException {
		ModelAndView mv = new ModelAndView();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String myEmail = authentication.getName();
		User user = userService.getById(id);
		boolean isMyPage = myEmail.equals(user.getEmail());
		if(isMyPage) return new ModelAndView("redirect:/my_page");
		int friendsStatus = friendshipService.getFriendsStatus(myEmail, id);
		logger.debug("friendsStatus : " + friendsStatus);
		mv.addObject("friendsStatus", friendsStatus);
		mv.addObject("isMyPage", false);
		mv.addObject("user", user);
		mv.setViewName("page");
		return mv;
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public String handleUserNotFoundException(){
		return "not_found";
	}
}
