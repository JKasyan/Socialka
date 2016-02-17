package com.kasyan.Socialka.dao;

import com.kasyan.Socialka.dto.Image;
import com.kasyan.Socialka.dto.SmallImage;
import com.kasyan.Socialka.dto.User;

public interface ImageDao {
	public void addImage(Image image, SmallImage smallImage);
	public Image getByNumber(int number);
	public SmallImage getSmallImage(User user);
}
