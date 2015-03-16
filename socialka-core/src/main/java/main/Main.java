package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Calendar;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kasyan.Socialka.Dto.Image;
import com.kasyan.Socialka.Dto.Password;
import com.kasyan.Socialka.Dto.User;
import com.kasyan.Socialka.Services.UserDaoService;

public class Main {
	
	private final static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) throws IOException, SerialException, SQLException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("socialka-app-ctx.xml");
		UserDaoService userService = (UserDaoService)context.getBean("userDaoService");
		
		File file = new File("/home/jeka/Робочий стіл/Images/Tugai.JPG");
		byte[] byteFile = new byte[(int) file.length()];
		FileInputStream inputStream = new FileInputStream(file);
		inputStream.read(byteFile);
		inputStream.close();
		logger.debug(byteFile.length);
		Blob blob = new SerialBlob(byteFile);
		Image image = new Image();
		image.setTitle("for_slavik");
		image.setPhoto(blob);
		userService.addImage(image);
		
		User user = new User();
		user.setEmail("tugai@ukr.net");
		user.setPassword("12345");
		user.setName("Jaroslav");
		user.setLastName("Tugai");
		Calendar calendar = Calendar.getInstance();
		calendar.set(1987, 17, 7);
		user.setDateOfBirth(calendar);
		user.setPhoto(image);
		image.getUsers().add(user);
		
		/*
		Password password = new Password();
		password.setPassword("12345");
		password.setUser(user);
		*/
		
		userService.addUser(user);
		logger.debug("Success!");
		
	}
}
