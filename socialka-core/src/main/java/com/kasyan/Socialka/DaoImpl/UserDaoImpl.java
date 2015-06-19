package com.kasyan.Socialka.DaoImpl;


import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.kasyan.Socialka.Dao.UserDao;
import com.kasyan.Socialka.Dto.User;
import com.kasyan.Socialka.Dto.UserRole;
import com.kasyan.Socialka.Exceptions.UserNotFoundException;

public class UserDaoImpl implements UserDao {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void addUser(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodePassword = encoder.encode(user.getPassword());
		user.setPassword(encodePassword);
		Session session = this.sessionFactory.openSession();
		Transaction transaction =  session.beginTransaction();
		session.save(user);
		UserRole userRole = new UserRole();
		userRole.setProfile(user);
		userRole.setRole("ROLE_USER");
		session.save(userRole);
		transaction.commit();
	}
	
	public User getByEmail(String email) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("select U from User U where U.email = :email");
		query.setString("email", email);
		return (User) query.uniqueResult();
		
	}
	
	public User getById(int id) throws UserNotFoundException{
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("select 1 from User U where U.id = :id");
		query.setInteger("id", id);
		if(query.uniqueResult() == null) throw new UserNotFoundException(id);
		return (User) session.load(User.class, id);
	}
	
	public List<User> getAllUsers() {
		String querySQL = "from User";
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery(querySQL);
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		return list;
	}

}
