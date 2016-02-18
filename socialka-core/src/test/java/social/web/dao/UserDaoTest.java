package social.web.dao;

import com.kasyan.Socialka.dao.UserDao;
import com.kasyan.Socialka.dto.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by evgen on 18.02.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:context/social-web-context.xml"})
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Test
    public void getUserTest() {
        List<User> allUsers = userDao.getAllUsers();
        System.out.println(allUsers);
    }
}
