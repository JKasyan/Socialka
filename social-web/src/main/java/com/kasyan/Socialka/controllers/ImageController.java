package com.kasyan.Socialka.controllers;

import java.sql.Blob;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kasyan.Socialka.dto.Image;
import com.kasyan.Socialka.services.ImageService;

@Controller
@RequestMapping("/getImage")
public class ImageController {
	
	@Autowired
	private ImageService imageService;
	private final Logger logger = Logger.getLogger(ImageController.class.getName());
	
	public void setImageService(ImageService imageService) {
		this.imageService = imageService;
	}

	@RequestMapping(value="/{number}", method=RequestMethod.GET)
	public void showImage(@PathVariable int number, HttpServletResponse response) throws Exception{
		logger.debug("Number of photo: "+number);
		response.setContentType("image/jpeg");
		Image image = imageService.getByNumber(number);
		byte[] bytes = image.getImageValue();
		response.getOutputStream().write(bytes);
		response.getOutputStream().flush();
		logger.debug("Success!");
	}
}
