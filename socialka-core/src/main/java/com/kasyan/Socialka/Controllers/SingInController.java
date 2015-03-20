package com.kasyan.Socialka.Controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kasyan.Socialka.Dto.User;
import com.kasyan.Socialka.Services.UserDaoService;

@Controller
@RequestMapping(value="sign_in")
public class SingInController {

	private UserDaoService userDaoService;
	private final Logger logger = Logger.getLogger(this.getClass().getName());

	public void setUserDaoService(UserDaoService userDaoService) {
		this.userDaoService = userDaoService;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String singIn(User user, Model model, HttpServletResponse res){
		String email=user.getEmail();
		String password = user.getPassword();
		logger.debug("Password: "+password+", Email: "+email);
		if(email!=null && password!=null){
			logger.debug("Pasword and email not null");
			User userValid = userDaoService.getByEmail(email);
			if(user!=null){
				if(userValid.getPassword().equals(password)){
					Cookie cookie = new Cookie("email", email);
					cookie.setMaxAge(60);
					res.addCookie(cookie);
					model.addAttribute(userValid);
					logger.debug("Succes loging");
					return "redirect:/friend/"+userValid.getId()+".do";
				}
			}else{
				logger.debug("User not exist in data base");
				return "redirect:/index.jsp";
			}
		}
		logger.debug("You did`nt enter password or email");
		return "redirect:/index.jsp";
	}
}
