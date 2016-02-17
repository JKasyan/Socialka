package com.kasyan.Socialka.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.kasyan.Socialka.dao.ImageDao;
import com.kasyan.Socialka.dto.Image;
import com.kasyan.Socialka.dto.SmallImage;
import com.kasyan.Socialka.dto.User;
import org.springframework.stereotype.Repository;

@Repository
public class ImageDaoImpl implements ImageDao {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addImage(Image image, SmallImage smallImage) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction =  session.beginTransaction();
		session.save(image);
		session.save(smallImage);
		transaction.commit();
		session.close();
	}

	public Image getByNumber(int number) {
		return null;
	}

	public SmallImage getSmallImage(User user) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("select 1 from SmallImage S where S.id = :id");
		query.setInteger("id", user.getId());
		return (SmallImage) session.load(User.class, user.getId());
	}

}
