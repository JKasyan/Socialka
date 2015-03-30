package com.kasyan.Socialka.Controllers;


import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.kasyan.Socialka.Dto.User;
import com.kasyan.Socialka.Exceptions.UserNotFoundException;
import com.kasyan.Socialka.Services.UserDaoService;

@Controller
@RequestMapping("/friend")
public class PageController {
	
	@Autowired
	private UserDaoService userDaoService;
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	public void setUserDaoService(UserDaoService userDaoService) {
		this.userDaoService = userDaoService;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String showFriendProfile(@PathVariable int id, Model model, HttpServletResponse response) 
			throws UserNotFoundException{
		logger.debug("Id: "+id);
		User user = (User)userDaoService.getById(id);
		model.addAttribute(user);
		return "page";
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public String handleUserNotFoundException(){
		return "not_found";
	}
}
