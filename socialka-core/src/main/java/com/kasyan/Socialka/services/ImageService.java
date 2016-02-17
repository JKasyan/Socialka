package com.kasyan.Socialka.services;

import com.kasyan.Socialka.dto.Image;
import com.kasyan.Socialka.dto.SmallImage;
import com.kasyan.Socialka.dto.User;

public interface ImageService {
	void addImage(Image image, SmallImage smallImage);
	Image getByNumber(int number);
	SmallImage getSmallImage(User user);
}
