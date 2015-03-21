package com.kasyan.Socialka.Controllers;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kasyan.Socialka.Dto.User;
import com.kasyan.Socialka.Services.UserDaoService;

@Controller
public class FriendsController {
	
	private UserDaoService userDaoService;
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	public void setUserDaoService(UserDaoService userDaoService) {
		this.userDaoService = userDaoService;
	}
	
	@RequestMapping(value="/my_friends", method=RequestMethod.GET)
	public String getMyFriends(HttpServletRequest req, Model model){
		Cookie[] cookies = req.getCookies();
		if(cookies!=null){
			logger.debug("Cookies not null");
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("email")){
					String email = cookie.getValue();
					logger.debug("Cookie value: "+email);
					List<User> friends = userDaoService.getFriends(email);
					model.addAttribute("friends", friends);
					return "my_friends";
				}
			}
		}
		return "redirect:/index.jsp";
	}

}
