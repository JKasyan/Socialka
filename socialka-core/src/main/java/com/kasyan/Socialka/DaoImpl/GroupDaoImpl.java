package com.kasyan.Socialka.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.kasyan.Socialka.Dao.GroupDao;
import com.kasyan.Socialka.Dto.Group;
import com.kasyan.Socialka.Dto.User;

public class GroupDaoImpl implements GroupDao {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void joinGroup(User user) {
	}

	public List<User> getMembers() {
		return null;
	}

	public Group getGroup(String title) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("select g from Group g where g.title =:title");
		query.setString("title", title);
		return (Group) query.uniqueResult();
	}

}
