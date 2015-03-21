package com.kasyan.Socialka.Controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogOutController {
	
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	@RequestMapping(value="/log_out", method=RequestMethod.GET)
	public String logout(HttpServletRequest req, HttpServletResponse res){
		Cookie loginCookie = null;
		Cookie[] cookies = req.getCookies();
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("email")){
					logger.debug("email: "+cookie.getValue());
					loginCookie=cookie;
					break;
				}
			}
		}
		if(loginCookie!=null){
			loginCookie.setMaxAge(0);
			res.addCookie(loginCookie);
		}
		return "redirect:/index.jsp";
	}
}
