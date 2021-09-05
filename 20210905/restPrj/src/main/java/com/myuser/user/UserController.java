package com.myuser.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.myuser.myuser.HomeController;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;
		
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("main")
	public String userMain() {
		return "main";
	}
	
	@GetMapping("select")
	@ResponseBody
	public User getUser(@RequestParam(defaultValue="1") int id) {
		
		logger.info("select 잘 들어옴!!");
		
		User user = userService.selectOne(id);
		
		return user;
	}
	
	// url 경로에 대한 부분을 받는 방법
	@GetMapping("select/{idx}")
	@ResponseBody
	public User getUserWithPathVariable(@PathVariable("idx") int id) {
		User user = userService.selectOne(id);
		return user;
	}
	
	@GetMapping("list")
	@ResponseBody
	public List<User> getUserList(){
		return userService.selectAll();
	}
	
	// 파일도 받는 input 화면 반환
	@GetMapping("input")
	public String inputForm() {
		return "input";
	}
	
	// 파일과 파라미터들을 받자
	@PostMapping("input")
	public String insertForm(User user, MultipartFile profile) {
		System.out.println(user);
		System.out.println(profile.getOriginalFilename());
		
		return "main";
	}
}
