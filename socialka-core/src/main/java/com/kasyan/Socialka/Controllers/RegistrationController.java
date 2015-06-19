package com.kasyan.Socialka.Controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kasyan.Socialka.Dto.User;
import com.kasyan.Socialka.Services.UserDaoService;

@Controller
@RequestMapping(value="/registration")
public class RegistrationController {
	
	@Autowired
	private UserDaoService userDaoService;
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	public void setUserDaoService(UserDaoService userDaoService) {
		this.userDaoService = userDaoService;
	}
	
	@RequestMapping(method=RequestMethod.GET, params="new")
	public ModelAndView createUser(){
		logger.debug("Create new profile");
		ModelAndView mv = new ModelAndView();
		mv.addObject(new User());
		mv.setViewName("registration");
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String saveUser(User user){
		logger.debug(user.toString());
		userDaoService.addUser(user);
		return "/login";
	}
}
