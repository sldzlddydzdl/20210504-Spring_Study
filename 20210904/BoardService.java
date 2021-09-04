package com.myboard.myboard.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	static final int BOARD_COUNT_PER_PAGE = 10;//한페이지당 보여줄 개수
	
	@Autowired
	BoardMapper boardMapper;
	
	//화면에 보여줄 데이타를 만들어서 반환
	public BoardListView getBoardListView(int pageNumber) {
		BoardListView boardListView = null;
		//전체 보드 개수
		int boardTotalCount = boardMapper.selectTotalCount(); 
		
		//요청된 페이지에 해당되는 보드리스트
		List<BoardDto> boardList = null;
		
		int firstRow = 0;
		
		//1-0
		//2-5
		//3-10
		//페이지 번호가 0이하가 될때는 1로 초기화 함.
		if(pageNumber <= 0) {
			pageNumber = 1;
		}
		firstRow = (pageNumber - 1) * BOARD_COUNT_PER_PAGE;

		//리스트를 매퍼로 가져옴
		boardList = boardMapper.selectBoard(firstRow, BOARD_COUNT_PER_PAGE);
		
		//화면에 보여줄 모든 데이터를 객체안에 넣어주자
		boardListView = new BoardListView(boardTotalCount, pageNumber, boardList, BOARD_COUNT_PER_PAGE, firstRow);
		
		return boardListView;
	}

	//게시글 하나를 가져오는 로직
	public BoardDto getBoard(int id) {
		return boardMapper.selectBoardById(id);
	}

	//게시글 수정하는 로직
	public void updateBoard(BoardDto board) {
		
		//수정일 날짜를 객체에 넣어줌.
		board.setUpdateDate(LocalDateTime.now());
		
		boardMapper.updateBoard(board);
	}
	
	//게시글 삭제
	public String deleteBoard(int id) {

		int row = boardMapper.deleteBoard(id);
		if(row > 0) {
			return "삭제 성공";
		}else {
			return "삭제 실패";
		}
	}
	
	//게시글 추가
	public String insertboard(BoardDto board) {
		
		// board 에 날짜를 채워 넣어야함
		LocalDateTime today = LocalDateTime.now();
		board.setWriteDate(today);
		board.setUpdateDate(today);
		
		// 매퍼를 이용하여 db에 값을 삽입
		int rows = boardMapper.insertBoard(board);
		if(rows >0) {
			return "삽입 성공";
		}else {
			return "삽입 실패";
		}
		
	}
	
}









