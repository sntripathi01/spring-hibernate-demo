package com.spring.hibernate.springhibernatedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.hibernate.springhibernatedemo.dao.HibernateDao;

@RestController
public class MyController {
	
	@Autowired
	private HibernateDao hibernateDao;
	
	@RequestMapping(method=RequestMethod.POST,value= "/save")
	public SaveUserResponse saveUser(@RequestBody User request){
	return	hibernateDao.saveUser(request);
	}
	@RequestMapping(method=RequestMethod.POST,value= "/allUser")
	public List<User> saveUser(){
	return	hibernateDao.getAllUser();
	}
}
