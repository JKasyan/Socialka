package com.kasyan.Socialka.Controllers;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kasyan.Socialka.Dto.User;
import com.kasyan.Socialka.Services.UserDaoService;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	private UserDaoService userDaoService;
	private final Logger logger = Logger.getLogger(this.getClass().getName());

	public void setUserDaoService(UserDaoService userDaoService) {
		this.userDaoService = userDaoService;
	}
	
	@RequestMapping(method=RequestMethod.GET, params="new")
	public String createProfile(Model model){
		model.addAttribute(new User());
		return "/login";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addUser(@Valid User user, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			logger.debug("Redirect to /login");
			return "login";
		}
		logger.debug(user.toString());
		userDaoService.addUser(user);
		int id = userDaoService.getByEmail(user.getEmail()).getId();
		return "redirect:/page/"+id;
	}
}