package com.kasyan.Socialka.Controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kasyan.Socialka.Dto.User;
import com.kasyan.Socialka.Exceptions.UserNotFoundException;
import com.kasyan.Socialka.Services.UserDaoService;

@Controller
@RequestMapping("/friend")
public class PageController {
	
	private UserDaoService userDaoService;
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	public void setUserDaoService(UserDaoService userDaoService) {
		this.userDaoService = userDaoService;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String showFriendProfile(@PathVariable int id, Model model, HttpServletResponse response) 
			throws UserNotFoundException{
		User user = null;
		logger.debug("Id: "+id);
		user = (User)userDaoService.getById(id);
		model.addAttribute(user);
		return "page";
	}
	
	@RequestMapping(value="/my_page", method=RequestMethod.GET)
	public ModelAndView myPage(HttpServletRequest req){
		ModelAndView mv = new ModelAndView();
		Cookie[] cookies = req.getCookies();
		if(cookies!=null){
			logger.debug("Cookies not null");
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("email")){
					String email = cookie.getValue();
					logger.debug("Cookie value: "+email);
					User user = (User)userDaoService.getByEmail(email);
					mv.addObject("user", user);
					mv.setViewName("page");
					return mv;
				}
			}
		}
		mv.setViewName("redirect:/index.jsp");
		return mv;
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public String handleUserNotFoundException(){
		return "not_found";
	}
}
