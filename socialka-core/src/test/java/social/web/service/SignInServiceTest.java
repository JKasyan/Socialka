package social.web.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by evgen on 19.02.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:context/social-web-context.xml"})
public class SignInServiceTest {

    @Autowired
    UserDetailsService userDetailsService;

    @Test
    public void loadUserByUsernameTest() {
        UserDetails user = userDetailsService.loadUserByUsername("user@gmail.com");
        System.out.println(user);
    }
}
