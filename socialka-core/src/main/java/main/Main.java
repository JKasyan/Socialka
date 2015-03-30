package main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.kasyan.Socialka.Dto.User;
import com.kasyan.Socialka.Services.UserDaoService;



public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("socialka-app-ctx.xml");
		UserDaoService service = (UserDaoService) context.getBean("userDaoService");
		List<User> friends = service.getFriends("evgen_kasyan@ukr.net");
		for(User friend:friends){
			System.out.println(friend.toString());
		}
	}
}
