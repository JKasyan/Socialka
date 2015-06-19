package com.kasyan.Socialka.DaoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.kasyan.Socialka.Dao.FriendshipDao;
import com.kasyan.Socialka.Dto.Friendship;
import com.kasyan.Socialka.Dto.Status;
import com.kasyan.Socialka.Dto.User;

public class FriendshipDaoImpl implements FriendshipDao {

	private SessionFactory sessionFactory;
	private final Logger logger = Logger.getLogger(this.getClass().getName());

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void confirmFriendship(int idOne, int idTwo) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session
					.createQuery("select 1 from Friendship F where F.idOne = :idOne and F.idTwo = :idTwo");
			query.setInteger("idOne", idOne);
			query.setInteger("idTwo", idTwo);
			Friendship friendship = (Friendship) query.uniqueResult();
			friendship.setStatus(Status.TWO);
			session.update(friendship);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> getFriends(int idOne) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = null;
		List<User> friends = null;
		try {
			transaction = session.beginTransaction();
			Query query = session
					.createQuery("select from Friendship F where F.idOne = :idOne and F.idTwo = :idOne");
			query.setInteger("idOne", idOne);
			friends = query.list();
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return friends;
	}

	public int getFriendsStatus(String emailOne, int idTwo) {
		Session session = this.sessionFactory.openSession();
		int friendStatus = 0;
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			User userOne = (User)session.createCriteria(User.class).
					add(Restrictions.eq("email", emailOne)).uniqueResult();
			User userTwo = (User)session.createCriteria(User.class).
					add(Restrictions.eq("id", idTwo)).uniqueResult();
			Friendship f = (Friendship) session.createCriteria(Friendship.class)
					.add(Restrictions.eq("friendOne", userOne))
					.add(Restrictions.eq("friendTwo", userTwo))
					.uniqueResult();
			if(f!=null){
				logger.debug("Status of friendship : "+f.getStatus());
				if(f.getStatus() == Status.ONE) friendStatus = 1;
				else if(f.getStatus() == Status.TWO) friendStatus = 2;
			}
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return friendStatus;
	}

	public void addProposalBeFriend(String emailOne, int idTwo) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			User userOne = (User)session.createCriteria(User.class).add(Restrictions.eq("email", emailOne)).uniqueResult();
			User userTwo = (User)session.createCriteria(User.class).add(Restrictions.eq("id", idTwo)).uniqueResult();
			Friendship friendship = new Friendship();
			friendship.setFriendOne(userOne);
			friendship.setFriendTwo(userTwo);
			friendship.setStatus(Status.ONE);
			session.save(friendship);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
