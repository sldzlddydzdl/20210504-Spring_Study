package user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	// 서비스를 이용함
	@Autowired
	UserService userService;
	
	// 리스트를 보내주는 메서드
	@GetMapping("/list") // localhost:8080/user/list
	public String userList(Model model) {
		
		// 서비스를 통하여 user리스트를 가져온다
		List<User> users = userService.getUserList(); 
		
		//화면에 보내주기위해 model 객체에 담아주자
		model.addAttribute("users" , users);
		
		return "list";
	}
	

}
