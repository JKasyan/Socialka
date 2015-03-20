package com.kasyan.Socialka.DaoImpl;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.kasyan.Socialka.Dao.UserDao;
import com.kasyan.Socialka.Dto.Image;
import com.kasyan.Socialka.Dto.User;

public class UserDaoImpl implements UserDao {
	
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addUser(User user) {
		saveObject(user);
	}

	@Override
	public boolean isEmailUnique(String email) {
		/*
		DetachedCriteria dc = DetachedCriteria.forEntityName(ENTITY_USER);
		String firstChar = email.substring(0, 1);
		logger.debug(firstChar);
		dc.add(Restrictions.or(Restrictions.like("email", firstChar, MatchMode.START)));
		List<User> users = (List<User>)getHibernateTemplate().findByCriteria(dc);
		logger.debug("Emails for comparing"+users);
		if(users!=null){
			for(User u:users){
				if(u.getEmail().equals(email)){
					logger.debug("This email exist in DB: "+u.getEmail());
					return false;
				}
			}
		}
		*/
		return true;
	}
	
	@Override
	public User getByEmail(String email) {
		Session session = this.sessionFactory.openSession();
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.like("email", email));
		return (User) cr.uniqueResult();
	}

	@Override
	public void addImage(Image image) {
		saveObject(image);
	}

	@Override
	public User getById(int id) {
		Session session = this.sessionFactory.openSession();
		User user = (User) session.load(User.class, id);
		return user;
	}
	
	private void saveObject(Object object){
		Session session = this.sessionFactory.openSession();
		Transaction transaction =  session.beginTransaction();
		session.persist(object);
		transaction.commit();
		session.close();
	}

	@Override
	public List<User> getFriends(String email) {
		//String query = "SELECT * FROM friends WHERE email="+email;
		Session session = this.sessionFactory.openSession();
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.like("email", email));
		List<User> list = cr.list();
		return list;
	}
}
