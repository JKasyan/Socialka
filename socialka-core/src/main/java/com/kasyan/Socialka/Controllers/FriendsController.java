package com.kasyan.Socialka.Controllers;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kasyan.Socialka.Dto.SmallImage;
import com.kasyan.Socialka.Dto.User;
import com.kasyan.Socialka.Services.FriendshipDaoService;

@Controller
public class FriendsController {
	
	@Autowired
	private FriendshipDaoService friendshipDaoService;
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	public void setFriendshipDaoService(FriendshipDaoService friendshipDaoService) {
		this.friendshipDaoService = friendshipDaoService;
	}

	@RequestMapping(value="/my_friends", method=RequestMethod.GET)
	public ModelAndView getMyFriends(HttpServletRequest req, Model model){
		ModelAndView mv = new ModelAndView();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		logger.debug("Email: "+email);
		if(email!="anonymousUser" && email!=null){
			List<User> friends = friendshipDaoService.getFriends(email);
			logger.debug("friends.size() "+friends.size());
			List<String> avatars = new ArrayList<String>();
			if(friends != null & !friends.isEmpty()){
				for(User user:friends){
					SmallImage smallImage = user.getSmallImage();
					if(smallImage!=null){
						Blob blob = smallImage.getSmallPhoto();
						int length = 0;
						byte[] bytes = null;
						try {
							length = (int)blob.length();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						try {
							bytes = smallImage.getSmallPhoto().getBytes(1, length);
						} catch (SQLException e) {
							e.printStackTrace();
						}
						byte[] encoded = Base64.encode(bytes);
						avatars.add(new String(encoded));
					}else{
						avatars.add(null);
					}
				}
			}
			logger.debug("avatars.size() "+avatars.size());
			mv.addObject("friends", friends);
			mv.addObject("avatars", avatars);
			mv.setViewName("my_friends");
			return mv;
		}
		mv.setViewName("redirect:/index.jsp");
		return mv;
	}
	
	@RequestMapping(value="/get_quant_proposals", method=RequestMethod.GET)
	public @ResponseBody String showProposalsBeFriend(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		long quantity = friendshipDaoService.getQuantityProposals(email);
		return "+"+String.valueOf(quantity);
	}
	
	@RequestMapping(value="/delete_from_friends", method=RequestMethod.GET)
	public @ResponseBody String deleteFromFriends(@RequestParam("idFriend") String id){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		logger.debug("User with email "+email+" wants to delete from friends user with id "+id);
		friendshipDaoService.deleteFromFriends(email, Integer.valueOf(id));
		return "succes";
	}
	
	@RequestMapping(value="/come_back_friend", method=RequestMethod.GET)
	public @ResponseBody String returnFriendship(@RequestParam("idFriend") String id){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String emailOne = authentication.getName();
		int idInt = Integer.valueOf(id);
		friendshipDaoService.returnFriendship(emailOne, idInt);
		logger.debug("User with email "+emailOne+" wants to return to friend user with id "+idInt);
		return "";
	}
}
