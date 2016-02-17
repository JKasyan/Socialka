package com.kasyan.Socialka.services;

import com.kasyan.Socialka.dto.Image;
import com.kasyan.Socialka.dto.SmallImage;
import com.kasyan.Socialka.dto.User;

public interface ImageDaoService {
	public void addImage(Image image, SmallImage smallImage);
	public Image getByNumber(int number);
	public SmallImage getSmallImage(User user);
}
