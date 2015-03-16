package com.kasyan.Socialka.Controllers;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kasyan.Socialka.Dto.User;
import com.kasyan.Socialka.Services.SignInService;

@Controller
public class SignInController {
	
	private SignInService signInService;
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	public void setSignInService(SignInService signInService) {
		this.signInService = signInService;
		//Cookie cookie = new Cookie();
	}

	@RequestMapping(value="sign_in")
	public ModelAndView signIn(HttpServletRequest request, HttpServletResponse response){

		ModelAndView modelAndView = new ModelAndView();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(email!=null & password!=null){
			logger.debug("Email and password are correct");
			Map<Boolean, Object> result = signInService.signIn(email, password);
			if(result.containsKey(true)){
				logger.debug("Enter...");
				User user = (User) result.get(true);
				modelAndView.addObject(user);
				modelAndView.setViewName("main");
				return modelAndView;
			}
		}
		logger.debug("Error in password or email");
		modelAndView.addObject("error", "Error in password or email");
		modelAndView.setViewName("index");
		return modelAndView;
	}
}
