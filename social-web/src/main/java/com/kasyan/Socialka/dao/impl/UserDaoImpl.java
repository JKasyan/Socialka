package com.kasyan.Socialka.dao.impl;


import java.util.List;


import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.kasyan.Socialka.dao.UserDao;
import com.kasyan.Socialka.dto.User;
import com.kasyan.Socialka.dto.UserRole;
import com.kasyan.Socialka.exceptions.UserNotFoundException;
import org.springframework.stereotype.Repository;

//@Repository
public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;
	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addUser(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodePassword = encoder.encode(user.getPassword());
		user.setPassword(encodePassword);
		Session session = this.sessionFactory.openSession();
		Transaction transaction =  session.beginTransaction();
		session.save(user);
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole("ROLE_USER");
		session.save(userRole);
		transaction.commit();
	}

	@Override
	public User getByEmail(String email) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("select U from User U where U.email = :email");
		query.setString("email", email);
		User user = (User) query.uniqueResult();
		logger.debug("User: " + user);
		session.close();
		return user;
	}

	@Override
	public User getById(int id) throws UserNotFoundException{
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("select 1 from User U where U.id = :id");
		query.setInteger("id", id);
		if(query.uniqueResult() == null) throw new UserNotFoundException(id);
		return (User) session.load(User.class, id);
	}

	@Override
	public List<User> getAllUsers() {
		String querySQL = "from User";
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery(querySQL);
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		return list;
	}

}
