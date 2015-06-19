package com.kasyan.Socialka.Controllers;

import java.sql.Blob;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kasyan.Socialka.Dto.Image;
import com.kasyan.Socialka.Services.ImageDaoService;

@Controller
@RequestMapping("/getImage")
public class ImageController {
	
	@Autowired
	private ImageDaoService imageDaoService;
	private final Logger logger = Logger.getLogger(ImageController.class.getName());
	
	public void setImageDaoService(ImageDaoService imageDaoService) {
		this.imageDaoService = imageDaoService;
	}

	@RequestMapping(value="/{number}", method=RequestMethod.GET)
	public void showImage(@PathVariable int number, HttpServletResponse response) throws Exception{
		logger.debug("Number of photo: "+number);
		response.setContentType("image/jpeg");
		Image image = imageDaoService.getByNumber(number);
		Blob blob = image.getPhoto();
		byte[] bytes = blob.getBytes(1, (int) blob.length());
		response.getOutputStream().write(bytes);
		response.getOutputStream().flush();
		logger.debug("Success!");
	}
}
