package com.spring.hibernate.springhibernatedemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.spring.hibernate.springhibernatedemo.controller.SaveUserResponse;
import com.spring.hibernate.springhibernatedemo.controller.User;

@Component
public class HibernateDao {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@SuppressWarnings("deprecation")
	public SaveUserResponse saveUser(User request) {
		SaveUserResponse saveUserResponse = new SaveUserResponse();
		Session session =  sessionFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Integer id = (Integer) session.save(request);
	    User data =	session.get(User.class, id);
	    tx.commit();
		session.close();
		if (null == id) {
			saveUserResponse.setMessage("FAIL");
		} else {
			saveUserResponse.setMessage("SUCCESS");
		}
		return saveUserResponse;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<User> getAllUser() {
		Session session =  sessionFactory.getSessionFactory().openSession();
		List<User> products = (List<User>) session.createQuery("from User").list();
		session.close();
		return products;
	}


}
