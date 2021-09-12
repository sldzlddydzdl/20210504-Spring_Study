package com.myuser.user;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

	// user 추가
	@Insert("insert into user(id, user_id, password, birth_date, join_date) values(#{id} , #{userId} , #{password} , #{birthDate} ,#{joinDate} )")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public int insertUser(User user);
	
	// user id로 조회
	@Select("select * from user where id = #{id}")
	public User selectUserById(@Param("id") int id);
	
	// list 전체 가져오기
	@Select("select * from user")
	public List<User> selectAll();
	
}
