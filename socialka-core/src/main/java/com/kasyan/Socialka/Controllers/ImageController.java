package com.kasyan.Socialka.Controllers;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kasyan.Socialka.Dto.Image;
import com.kasyan.Socialka.Dto.User;
import com.kasyan.Socialka.Services.UserDaoService;

@Controller
@RequestMapping("/getImage")
public class ImageController {
	
	private UserDaoService userDaoService;
	private final Logger logger = Logger.getLogger(ImageController.class.getName());
	
	public void setUserDaoService(UserDaoService userDaoService) {
		this.userDaoService = userDaoService;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public void showImage(@PathVariable int id, HttpServletResponse response) throws SQLException, IOException{
		logger.debug("Id: "+id);
		response.setContentType("image/jpeg");
		User user = userDaoService.getById(id);
		Image image = user.getPhoto();
		Blob blob = image.getPhoto();
		byte[] bytes = blob.getBytes(1, (int) blob.length());
		response.getOutputStream().write(bytes);
		response.getOutputStream().flush();
		logger.debug("Success!");
	}
}
