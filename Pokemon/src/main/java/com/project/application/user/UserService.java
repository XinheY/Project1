package com.project.application.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	
	@Autowired
	private UserDao ud;

	public User findByEmail(String email) {
		List<User> user=new ArrayList<User>();
		User u=null;
		ud.findAll().forEach(user::add);
		for(int i=0;i<user.size();i++) {
			if(user.get(i).getEmail().equals(email)) {
				u=user.get(i);
				return u;
			}
		}
		return u;
		
	}

	public void addNew(User user) {
		ud.save(user);
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return ud.findAll();
	}
	
	public boolean isOnline(String email) {
		List<User> user=new ArrayList<User>();
		ud.findAll().forEach(user::add);
		for(int i=0;i<user.size();i++) {
			if(user.get(i).getEmail().equals(email)) {
				return user.get(i).isOnline();
			}
		}
		return false;
	}

	public void updateUser(User checkuser) {
		ud.save(checkuser);
		
	}

}
