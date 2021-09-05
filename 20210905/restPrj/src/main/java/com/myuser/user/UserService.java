package com.myuser.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public String insertUser(User user) {
		
		System.out.println("디비 삽입 전 user 객체");
		System.out.println(user);
		
		int rows = userMapper.insertUser(user);
		
//		User user1 =  userMapper.selectUserById(rows);
		System.out.println("디비 삽입 후 user 객체");
		System.out.println(user);
		
		if( rows > 0) {
			return "삽입 성공";
		}else {
			return "삽입 실패";
		}
		
	}
	
	public User selectOne(int id) {
		
		
		return userMapper.selectUserById(id);
				
	}
	
	public List<User> selectAll(){
		return userMapper.selectAll();
	}
	
}
