package com.kasyan.Socialka.services.impl;

import com.kasyan.Socialka.dao.ImageDao;
import com.kasyan.Socialka.dto.Image;
import com.kasyan.Socialka.dto.SmallImage;
import com.kasyan.Socialka.dto.User;
import com.kasyan.Socialka.services.ImageService;

public class ImageServiceImpl implements ImageService {
	
	private ImageDao imageDao;

	public void setImageDao(ImageDao imageDao) {
		this.imageDao = imageDao;
	}

	public void addImage(Image image, SmallImage smallImage) {
		imageDao.addImage(image, smallImage);
	}

	public Image getByNumber(int number) {
		return imageDao.getByNumber(number);
	}

	public SmallImage getSmallImage(User user) {
		return imageDao.getSmallImage(user);
	}

}
