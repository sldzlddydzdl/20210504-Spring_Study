package com.myboard.myboard.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

//마이바티스를 이용해서 넣어줘야하는데...
//마이바티스 추가를 해야함!!

@Mapper
public interface BoardMapper {
	
	//추가
	@Insert("insert into board(id, title, content, writer, write_date, update_date) "
			+ "values(#{id},#{title},#{content},#{writer},#{writeDate},#{updateDate})")
	public void insertBoard(BoardDto boardDto);
	
	@Select("select id, title, content, writer, write_date, update_date "
			+ "from board order by id desc limit #{startRow},#{boardCountPerPage}")
	public List<BoardDto> selectBoard(@Param("startRow")int startRow, @Param("boardCountPerPage")int boardCountPerPage);
	
	//전체 개수 가져오는 메서드
	@Select("select count(*) from board")
	public int selectTotalCount();
	
	//게시글을 id로 가져오는 메서드
	@Select("select id, title, content, writer, write_date, update_date "
			+ "from board where id=#{id}")
	public BoardDto selectBoardById(int id);
	
	//게시글 수정하는 메서드
	@Update("update board set title=#{title}, writer=#{writer}, content=#{content}, "
			+ "write_date=#{writeDate}, update_date=#{updateDate} where id=#{id}")
	public void updateBoard(BoardDto board);
	
	//게시글 삭제하는 메서드
	@Delete("delete from board where id=#{id}")
	public int deleteBoard(int id);
}






