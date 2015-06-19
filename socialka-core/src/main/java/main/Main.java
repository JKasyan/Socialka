package main;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kasyan.Socialka.Dto.Friendship;
import com.kasyan.Socialka.Dto.Group;
import com.kasyan.Socialka.Dto.Image;
import com.kasyan.Socialka.Dto.SmallImage;
import com.kasyan.Socialka.Dto.User;
import com.kasyan.Socialka.Exceptions.UserNotFoundException;
import com.kasyan.Socialka.Services.FriendshipDaoService;
import com.kasyan.Socialka.Services.GroupDaoService;
import com.kasyan.Socialka.Services.ImageDaoService;
import com.kasyan.Socialka.Services.UserDaoService;
import com.kasyan.Socialka.Utils.ImageResize;

/**
 * @version
 * @author Evgen Kasyan
 * @version 1.0
 * 
 */
public class Main {

	public static void main(String args[]) {
		/*
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("socialka-app-ctx.xml");
		UserDaoService service = (UserDaoService) context.getBean("userDaoService");
		/*
		User user = new User();
		user.setEmail("mykola@gmail.com");
		user.setPassword("123456");
		user.setName("Mykola");
		user.setLastName("Vasilenko");
		service.addUser(user);
		*/
		/*
		String[] secondNames = {"Kovalenko","Petrenko", "Ivanenko", "Marchenko","Vasilenko"};
		String[] names = {"Ivan","Evgen", "Sasha", "Petro","Vika"};
		Random random = new Random();
		for(int i=0;i<10;i++){
			User user = new User();
			String name = names[random.nextInt(names.length-1)];
			String userName = secondNames[random.nextInt(names.length-1)];
			user.setEmail(userName+name+"@gmail.com");
			user.setPassword("123456");
			user.setName(name);
			user.setLastName(userName);
			service.addUser(user);
		}
		*/
		/*
		List<User> list = new ArrayList<User>();
		//List<User> list = service.getAllUsers();
		
		for (int i = 0; i < 399; i++) {
			try {
				//if(i==7) continue;
				//System.out.println(5);
				User user = service.getById(5);
				list.add(user);
				//System.out.println(user);
				/*
				try {
					TimeUnit.MILLISECONDS.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
		/*
			} catch (UserNotFoundException e) {
				e.printStackTrace();
			}
		}
		*/
		//System.out.println(list);
		
		/*
		try {
			BufferedImage original = ImageIO.read(new File("C:\\Users\\Evgen\\Desktop\\default-avatar.png"));
			int type = original.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : original.getType();
			BufferedImage resized = ImageResize.resizeImage(original, type);
			ImageIO.write(resized, "jpg", new File("C:\\Users\\Evgen\\Desktop\\new_avatar.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		/*
		ApplicationContext context = new ClassPathXmlApplicationContext("socialka-app-ctx.xml");
		ImageDaoService service = (ImageDaoService) context.getBean("imageDaoService");
		UserDaoService userDaoService = (UserDaoService) context.getBean("userDaoService");
		try {
			User user = userDaoService.getById(5);
			File file  = new File("C:\\Users\\Evgen\\Desktop\\VTuX-Fl2wXI.jpg");
			byte[] array = Files.readAllBytes(file.toPath());
			SmallImage si = new SmallImage();
			si.setSmallPhoto(new SerialBlob(array));
			si.setUser(user);
			
			
			BufferedImage original = ImageIO.read(file);
			int type = original.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : original.getType();
			BufferedImage resized = ImageResize.resizeImage(original, type);
			Image image  = new Image();
			image.setTitle("Vika_and_Jenya");
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(resized, "jpg", baos);
			baos.flush();
			Blob blob  = new SerialBlob(baos.toByteArray());
			image.setPhoto(blob);
			image.setUser(user);
			service.addImage(image, si);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SerialException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		*/
		
		/*
		ApplicationContext context = new ClassPathXmlApplicationContext("socialka-app-ctx.xml");
		UserDaoService userDaoService =  (UserDaoService) context.getBean("userDaoService");
		User user = userDaoService.getByEmail("vika@gmail.com");
		System.out.println(user);
		*/
		ApplicationContext context = new ClassPathXmlApplicationContext("socialka-app-ctx.xml");
		FriendshipDaoService friendshipService = (FriendshipDaoService) context.getBean("friendshipDaoService");
		UserDaoService userDaoService = (UserDaoService) context.getBean("userDaoService");
		friendshipService.addProposalBeFriend("vika@gmail.com", new Integer(9));
	}
}
