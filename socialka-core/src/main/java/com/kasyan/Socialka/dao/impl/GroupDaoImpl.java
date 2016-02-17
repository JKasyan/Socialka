package com.kasyan.Socialka.dao.impl;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.kasyan.Socialka.dao.GroupDao;
import com.kasyan.Socialka.dto.Group;
import com.kasyan.Socialka.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
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
