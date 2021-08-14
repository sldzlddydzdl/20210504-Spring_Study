package user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@RequestMapping("/hello")
	public String helloView() {
		
		System.out.println("helloView 메서드 실행!");
		
		
		// 이 페이지의 파일주소에 해당되는 jsp 파일을 클라이언트에게 보내게된다.
		return "/WEB-INF/view/hello.jsp";
	}
	
	@RequestMapping(path = "/hello2" , method = RequestMethod.GET)
	public ModelAndView helloMV() {
		System.out.println("helloMV() 메서드 호출 됨");
		ModelAndView mv = new ModelAndView();
		
		//mv 에 화면에다가 보내줄 데이타를 담기
		// 키 , 데이타 
		mv.addObject("greeting" , "hello world!!");
		mv.addObject("number" , 100);
		
		// 결과 하면(view) 정보도 추가해줌
		mv.setViewName("/WEB-INF/view/greet.jsp");
		
		return mv;
	}
	
	@GetMapping("/hello3")
	public String hello3(Model model) {
		model.addAttribute("greeting2" , "안녕하세요");
		List<String> list = new ArrayList<>();
		
		list.add("밥");
		list.add("국");
		
		model.addAttribute("food" ,list);
		return "/WEB-INF/view/hello3.jsp";
		
	}
	
	@GetMapping("/food")
	public String showfood(Model model) {
		
		List<String> list = new ArrayList<>();
		
		list.add("짜장면");
		list.add("짬뽕");
		list.add("탕수육");
		
		model.addAttribute("food" , list);
		
		return "/WEB-INF/view/foodlist.jsp";
	}
	
	
}
