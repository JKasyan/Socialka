package com.kasyan.Socialka.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
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


	@SuppressWarnings({ "unchecked" })
	public List<User> getFriends(String email) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = null;
		List<User> friends = new ArrayList<User>();
		try {
			transaction = session.beginTransaction();
			User user = (User)session.createCriteria(User.class).
					add(Restrictions.eq("email", email)).uniqueResult();
			friends.addAll(session.createCriteria(Friendship.class).
					add(Restrictions.eq("friendOne", user)).
					add(Restrictions.eq("status", Status.TWO)).
					setProjection(Projections.property("friendTwo")).list());
			friends.addAll(session.createCriteria(Friendship.class).
					add(Restrictions.eq("friendTwo", user)).
					add(Restrictions.eq("status", Status.TWO)).
					setProjection(Projections.property("friendOne")).list());
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
	
	//Change this method
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
			Criterion crOne = Restrictions.and(Restrictions.eq("friendOne", userOne), Restrictions.eq("friendTwo", userTwo));
			Criterion crTwo = Restrictions.and(Restrictions.eq("friendOne", userTwo), Restrictions.eq("friendTwo", userOne));
			Criteria criteria = session.createCriteria(Friendship.class);
			criteria.add(Restrictions.or(crOne, crTwo));
			Friendship f = (Friendship) criteria.uniqueResult();
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
	
	public Long getQuantityProposals(String email){
		Session session = this.sessionFactory.openSession();
		Transaction transaction = null;
		Long quantity = 0L;
		try {
			transaction = session.beginTransaction();
			User user = (User)session.createCriteria(User.class).
					add(Restrictions.eq("email", email)).uniqueResult();
			Criteria cr = session.createCriteria(Friendship.class);
			cr.add(Restrictions.eq("friendTwo", user)).
			add(Restrictions.eq("status", Status.ONE)).
			setProjection(Projections.rowCount());
			quantity = (Long) cr.uniqueResult();
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return quantity;
	}

	public void deleteFromFriends(String emailOne, int idTwo) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Friendship fr = getFriendshipByEmailAndId(emailOne, idTwo, session);
			logger.debug("Friendship "+fr);
			fr.setStatus(Status.ONE);
			session.update(fr);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void changeFriendshipStatus(String emailOne, int idTwo) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = null;
		try {
		transaction = session.beginTransaction();
		Friendship fr = getFriendshipByEmailAndId(emailOne, idTwo, session);
		fr.setStatus(Status.TWO);
		logger.debug("Friendship "+fr);
		session.update(fr);
		transaction.commit();
		}catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	private Friendship getFriendshipByEmailAndId(String emailOne, int idTwo, Session session){
		User userOne = (User)session.createCriteria(User.class).
				add(Restrictions.eq("email", emailOne)).uniqueResult();
		User userTwo = (User)session.createCriteria(User.class).
				add(Restrictions.eq("id", idTwo)).uniqueResult();
		Criterion crOne = Restrictions.and(Restrictions.eq("friendOne", userOne), Restrictions.eq("friendTwo", userTwo));
		Criterion crTwo = Restrictions.and(Restrictions.eq("friendOne", userTwo), Restrictions.eq("friendTwo", userOne));
		Criteria criteria = session.createCriteria(Friendship.class);
		criteria.add(Restrictions.or(crOne, crTwo));
		return (Friendship) criteria.uniqueResult();
	}

	public void update(Friendship fr) {
		Session session = this.sessionFactory.openSession();
		session.update(fr);
	}
}
