package com.myuser.user;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myuser.user.User;
import com.myuser.user.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void test() {
		User user = new User(0, "유저아이디1" ,"패스워드1" , LocalDate.now() , LocalDateTime.now());
		
		String result = userService.insertUser(user);
		System.out.println(result);
	}

}
