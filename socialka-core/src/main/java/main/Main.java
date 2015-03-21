package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kasyan.Socialka.Dto.Friend;
import com.kasyan.Socialka.Dto.Image;
import com.kasyan.Socialka.Dto.Password;
import com.kasyan.Socialka.Dto.User;
import com.kasyan.Socialka.Services.UserDaoService;

public class Main {
	
	private final static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) throws IOException, SerialException, SQLException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("socialka-app-ctx.xml");
		UserDaoService userService = (UserDaoService)context.getBean("userDaoService");
		
		/*
		File file = new File("C://Users//Evgen//Desktop//london.jpg");
		byte[] byteFile = new byte[(int) file.length()];
		FileInputStream inputStream = new FileInputStream(file);
		inputStream.read(byteFile);
		inputStream.close();
		logger.debug(byteFile.length);
		Blob blob = new SerialBlob(byteFile);
		Image image = new Image();
		image.setTitle("Vetal");
		image.setPhoto(blob);
		userService.addImage(image);
		
		User user = new User();
		user.setEmail("vetal_dvorkovui@ukr.net");
		user.setPassword("12345");
		user.setName("Vetal");
		user.setLastName("Dvorkovui");
		Calendar calendar = Calendar.getInstance();
		calendar.set(1986, 14, 6);
		user.setDateOfBirth(calendar);
		user.setPhoto(image);
		image.getUsers().add(user);
		userService.addUser(user);
		*/
		
		
		List<User> list = userService.getFriends("evgen_kasyan@ukr.net");
		logger.debug(list.size());
		for(User friend:list){
			logger.debug(friend.toString());
		}
		logger.debug("Success!");
		

		/*
		Friend friend = new Friend();
		friend.setEmail("igor_kornienko@i.ua");
		friend.setFriend(2);
		userService.addFriendship(friend);
		logger.debug("Success!");
		*/
	}
}
