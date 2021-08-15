package user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// service
// 비지니스 로직을 구현하는 부분
// 예) 게시판 보여줘! 게시판에 관련된 데이타를 가져오고 필요한 기능을 수행하는 부분

@Service
public class UserService {
	
	// 매퍼를 이용하여 디비에 쿼리를 실행
	@Autowired
	UserMapper userMapper;
	
	public List<User> getUserList(){
		return userMapper.selectUsers();
	}
	
}
