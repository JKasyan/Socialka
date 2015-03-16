package com.kasyan.Socialka.DaoImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.kasyan.Socialka.Dao.SignInDao;
import com.kasyan.Socialka.Dto.User;

public class SignInDaoImpl extends HibernateDaoSupport implements SignInDao {
	
	public static final String ENTITY_USER = "User";
	
	@Override
	public Map<Boolean, Object> signIn(String email, String password) {
		User user = (User)getHibernateTemplate().get(ENTITY_USER, email);
		if(user!=null){
			Map<Boolean, Object> result = new  HashMap<Boolean, Object>();
			Boolean acces = user.getPassword().equals(password);
			if(acces){
				result.put(acces, user);
				return result;
			}else{
				result.put(acces, null);
				return result;
			}
		}
		throw new RuntimeException("Error in email or password");
	}
}
