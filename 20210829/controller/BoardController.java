package com.myboard.myboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myboard.myboard.model.BoardDto;
import com.myboard.myboard.model.BoardListView;
import com.myboard.myboard.model.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("list")
	public String boardList(@RequestParam(defaultValue = "0") int pageNumber, Model model) {
		//여기에서 서비스를 이용하여 화면에 보여줄 데이타를 가져온다.
		BoardListView boardListView = boardService.getBoardListView(pageNumber);
		
		//화면에 보내기위해 모델에 넣어준다.
		model.addAttribute("boardListView", boardListView);
		return "list";
	}
	
	//상세보기
	@GetMapping("detail")
	public String boardDetail(int id, Model model) {
		//서비스를 통해서 해당되는 게시글 정보를 가져와 화면에 보내준다
		BoardDto board = boardService.getBoard(id);
		model.addAttribute("board", board);

		return "detail";
	}
	
	//수정화면으로 가기
	@GetMapping("update")
	public String boardUpdateForm(int id, Model model) {
		BoardDto board = boardService.getBoard(id);
		model.addAttribute("board", board);
		
		return "update";
	}
	
	//수정
	@PostMapping("update")
	public String boardUpdate(BoardDto board) {
		
		logger.info("보드 : "+board);
		//서비스로 게시글 수정작업을 해야함.
		boardService.updateBoard(board);
		
		return "redirect:list";
	}
	
	//삭제
	@PostMapping("delete")
	public String boardDelete(int id, RedirectAttributes re) {
		logger.info("아이디 : "+id);
		String result = boardService.deleteBoard(id);
		
		re.addFlashAttribute("result", result);
		return "redirect:list";
	}
}





