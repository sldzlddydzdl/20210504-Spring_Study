package com.myuser.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserWithImageMapper {
	
	@Insert("insert into user(id, user_id, password, birth_date, join_date, image_file_name)"
			+ " values(#{id},#{userId},#{password},#{birthDate},#{joinDate},#{imageFileName})")
	public int insertUserWithImage(UserWithImage user);
	
	@Select("select * from user where id=#{id}")
	public UserWithImage selectUserWithImageById(int id);
	

}
