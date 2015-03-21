package com.kasyan.Socialka.DaoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.kasyan.Socialka.Dao.UserDao;
import com.kasyan.Socialka.Dto.Friend;
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
		String queryId = "select F.friend from Friend F where email = :email";
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery(queryId);
		query.setString("email", email);
		List<Integer> listIdFriends = query.list();
		List<User> friends = new ArrayList<User>(listIdFriends.size());
		Query queryGetFriends = session.createQuery("from User U where U.id in (:listIdFriends)");
		queryGetFriends.setParameterList("listIdFriends", listIdFriends);
		friends = queryGetFriends.list();
		return friends;
	}

	@Override
	public List<User> getAllUsers() {
		String querySQL = "from User";
		logger.debug(querySQL);
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery(querySQL);
		List<User> list = query.list();
		return list;
	}

	@Override
	public void addFriendship(Friend friend) {
		saveObject(friend);
	}
}
