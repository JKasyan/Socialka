package com.kasyan.Socialka.Controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kasyan.Socialka.Dto.User;
import com.kasyan.Socialka.Services.UserDaoService;

@Controller
public class MyPageController {
	
	@Autowired
	private UserDaoService userDaoService;
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	public void setUserDaoService(UserDaoService userDaoService) {
		this.userDaoService = userDaoService;
	}
	
	@RequestMapping(value="/my_page", method=RequestMethod.GET)
	public ModelAndView myPage(HttpServletRequest req){
		ModelAndView mv = new ModelAndView();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		if(email!="anonymousUser"){
			logger.debug("Email : "+email);
			User user = (User)userDaoService.getByEmail(email);
			mv.addObject("user", user);
			mv.setViewName("page");
			return mv;
		}
		mv.setViewName("redirect:/index.jsp");
		return mv;
	}
}