package com.myuser.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserWithImageService {
	
	@Autowired
	UserWithImageMapper userWithImageMapper;
	
	public void insertUserWithImage(UserWithImage user) {
		userWithImageMapper.insertUserWithImage(user);
	}
	
	public UserWithImage selectUserWithImage(int id) {
		return userWithImageMapper.selectUserWithImageById(id);
	}

}
