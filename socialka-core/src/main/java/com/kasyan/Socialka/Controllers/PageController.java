package com.kasyan.Socialka.Controllers;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kasyan.Socialka.Dto.Image;
import com.kasyan.Socialka.Dto.User;
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
			throws IOException, SQLException{
		logger.debug("Id: "+id);
		User user = (User)userDaoService.getById(id);
		model.addAttribute(user);
		return "page";
	}
	
	@RequestMapping(value="/my_page", method=RequestMethod.GET)
	public String myPage(HttpServletRequest req, Model model){
		Cookie[] cookies = req.getCookies();
		if(cookies!=null){
			logger.debug("Cookies not null");
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("email")){
					String email = cookie.getValue();
					logger.debug("Cookie value: "+email);
					User user = (User)userDaoService.getByEmail(email);
					model.addAttribute(user);
					return "page";
				}
			}
		}
		return "redirect:/index.jsp";
	}
}
