package com.myuser.user;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@Autowired
	UserWithImageService userWithImageService;
		
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
		
		// 이미지 파일을 원하는 폴더에 저장을 하자~
		String uploadFolder = "C:\\Users\\rlaeh\\filetemp";
		
		String fileName =  UUID.randomUUID().toString()+profile.getOriginalFilename();
		
		
		File file = new File(uploadFolder ,  fileName);
		
		try {
			profile.transferTo(file);
			
			UserWithImage userWithImage = new UserWithImage(user.getId(), user.getUserId(), user.getPassword(), user.getBirthDate(), user.getJoinDate(), fileName);
			
			userWithImageService.insertUserWithImage(userWithImage);
			
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "main";
	}
	
	@GetMapping("get/{id}")
	public String getUser(@PathVariable("id") int id, Model model) {
		
		UserWithImage user = userWithImageService.selectUserWithImage(id);
		model.addAttribute("user", user);
		
		return "userView";
	}
	
}
