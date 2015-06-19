package com.kasyan.Socialka.ServicesImpl;

import com.kasyan.Socialka.Dao.ImageDao;
import com.kasyan.Socialka.Dto.Image;
import com.kasyan.Socialka.Dto.SmallImage;
import com.kasyan.Socialka.Dto.User;
import com.kasyan.Socialka.Services.ImageDaoService;

public class ImageDaoServiceImpl implements ImageDaoService {
	
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
