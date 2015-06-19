package com.kasyan.Socialka.Controllers;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kasyan.Socialka.Dto.SmallImage;
import com.kasyan.Socialka.Dto.User;
import com.kasyan.Socialka.Exceptions.UserNotFoundException;
import com.kasyan.Socialka.Services.FriendshipDaoService;
import com.kasyan.Socialka.Services.UserDaoService;

@Controller
@RequestMapping("/friend")
public class PageController {
	
	@Autowired
	private UserDaoService userDaoService;
	@Autowired
	private FriendshipDaoService friendshipDaoService;
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	public void setUserDaoService(UserDaoService userDaoService) {
		this.userDaoService = userDaoService;
	}
	
	public void setFriendshipDaoService(FriendshipDaoService friendshipDaoService) {
		this.friendshipDaoService = friendshipDaoService;
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView showFriendProfile(@PathVariable int id, Model model, HttpServletResponse response) 
			throws UserNotFoundException{
		ModelAndView mv = new ModelAndView();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String myEmail = authentication.getName();
		User user = userDaoService.getById(id);
		boolean isMyPage = myEmail.equals(user.getEmail());
		int friendsStatus = 0;
		if(!isMyPage){
			friendsStatus = friendshipDaoService.getFriendsStatus(myEmail, id);
		}
		List<SmallImage> images = user.getSmallImages();
		String encodedString = null;
		if(images!=null){
			SmallImage image = images.get(images.size()-1);
			Blob blob = image.getSmallPhoto();
			int length = 0;
			byte[] bytes = null;
			try {
				length = (int)blob.length();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				bytes = image.getSmallPhoto().getBytes(1, length);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			byte[] encoded = Base64.encode(bytes);
			encodedString = new String(encoded);
		}
		logger.debug("friendsStatus : "+friendsStatus);
		mv.addObject("friendsStatus", friendsStatus);
		mv.addObject("isMyPage", isMyPage);
		mv.addObject("user", user);
		mv.addObject("image", encodedString);
		mv.setViewName("page");
		return mv;
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public String handleUserNotFoundException(){
		return "not_found";
	}
}
