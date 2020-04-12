package com.rest.demo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rest.demo.model.User;

@Component
public class UserDaoService {
	
	private static List<User> list=new ArrayList();
	private static int idCounter=3;
	static {
		list.add(new User(1, "Dhanu", new Date()));
		list.add(new User(2, "Seetha", new Date()));
		list.add(new User(3, "swathi", new Date()));
	}
	
	public List<User> findAll(){
		return list;
	}
	
	public User save(User user) {
		if(user.getUserId()==0) {
			user.setUserId(++idCounter);
		}
		list.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User us:list) {
			if(us.getUserId()==id) {
				return us;
			}
		}
		return null;
	}
}
