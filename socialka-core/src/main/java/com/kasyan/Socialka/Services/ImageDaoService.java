package com.kasyan.Socialka.Services;

import com.kasyan.Socialka.Dto.Image;
import com.kasyan.Socialka.Dto.SmallImage;
import com.kasyan.Socialka.Dto.User;

public interface ImageDaoService {
	public void addImage(Image image, SmallImage smallImage);
	public Image getByNumber(int number);
	public SmallImage getSmallImage(User user);
}
