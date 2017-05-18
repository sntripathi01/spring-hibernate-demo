package com.spring.hibernate.springhibernatedemo.controller;

import static org.junit.Assert.assertEquals;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.spring.hibernate.springhibernatedemo.dao.HibernateDao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MyControllerTest {

	@Autowired
	private HibernateDao hibernateDao;

	@Autowired
	@Qualifier("mockSessionFactory")
	private SessionFactory sessionFactory;

	@Before
	public void setUp() {
		ReflectionTestUtils.setField(hibernateDao, "sessionFactory", sessionFactory);
	}

	@Test
	public void testSaveUserUser() {
		User request = new User();
		request.setAddress("AD");
		request.setName("Sach");
		SaveUserResponse response = hibernateDao.saveUser(request);
		assertEquals("SUCCESS", response.getMessage());
	}

	@Test
	public void testSaveUser() {
		// fail("Not yet implemented");
	}

}
