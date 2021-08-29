package com.myboard.myboard.model;

import java.util.List;

//리스트화면에 보여줄 정보를 담을 아이!
//보여지는 페이지에 대한 내용만 담김.

//페이지번호, 페이지 목록(보드리스트), 전체 메시지 개수, page 개수,
//페이지당 보여줄 메시지 개수
public class BoardListView {
	private int boardTotalCount;//게시글 전체 개수
	private int currentPageNumber;//현재페이지 번호
	private List<BoardDto> boardList;//한 화면에 보여줄 게시글 리스트
	private int pageTotalCount;//페이지 전체 개수
	private int boardCountPerPage;//한 페이지당 보드 개수
	private int firstRow;//화면상 맨 위에 있는 레코드 로우번호.
	
	public BoardListView(int boardTotalCount, int currentPageNumber, List<BoardDto> boardList,
			int boardCountPerPage, int firstRow) {
		super();
		this.boardTotalCount = boardTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.boardList = boardList;
		this.boardCountPerPage = boardCountPerPage;
		this.firstRow = firstRow;
		
		//페이지 전체 개수를 계산해보자.
		pageTotalCount = (int)Math.ceil((double)boardTotalCount/boardCountPerPage);
	}

	public int getBoardTotalCount() {
		return boardTotalCount;
	}
	public int getCurrentPageNumber() {
		return currentPageNumber;
	}
	public List<BoardDto> getBoardList() {
		return boardList;
	}
	public int getPageTotalCount() {
		return pageTotalCount;
	}
	public int getBoardCountPerPage() {
		return boardCountPerPage;
	}
	public int getFirstRow() {
		return firstRow;
	}

	@Override
	public String toString() {
		return "BoardListView [boardTotalCount=" + boardTotalCount + ", currentPageNumber=" + currentPageNumber
				+ ", boardList=" + boardList + ", pageTotalCount=" + pageTotalCount + ", boardCountPerPage="
				+ boardCountPerPage + ", firstRow=" + firstRow + "]";
	}
}









