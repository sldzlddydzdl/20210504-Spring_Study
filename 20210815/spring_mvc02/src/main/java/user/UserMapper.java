package user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

// 쿼리를 마이바티스를 이용하여 실행하도록 하는 인터페이스
// Mapper는 마이바티스가 이 어노테이션이 있는 아이들을 이용해서 디비에 쿼리를 실행하게디ㅗㄴ다

@Mapper
public interface UserMapper {
	
	// 디비에 있는 user 정보를 list 로 담아 반환하는 메서드
	@Select("select id, user_id, password, birth_date , join_date from user")
	public List<User> selectUsers();
}
