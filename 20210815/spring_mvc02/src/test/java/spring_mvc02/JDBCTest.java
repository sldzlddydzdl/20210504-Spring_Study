package spring_mvc02;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root_context.xml")
public class JDBCTest {
	
	// 스프링 컨테이너 들어있는 datasource 빈을 가져오자
	@Autowired
	DataSource dataSource;

	@Test
	public void test() {
		assertNotNull(dataSource);
	}

}
