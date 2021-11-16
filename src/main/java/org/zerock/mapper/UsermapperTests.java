package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.UserVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

public class UsermapperTests {

	
	@Autowired //
	private UserMapper usermapper; //Usermapper.java 	인터페이스의 의존성 주입
	//       UserMapper.java 를 usermapper라고 지정 
	//회원가입 쿼리 테스 메서드
	
	@Test
	public void User() throws Exception{
//  User 함수지정
		UserVO user = new UserVO();
// UserVO.java를 		
		user.setUser_id("1");
		user.setUser_name("spring_test");
		user.setUser_pw("spring_test");
		user.setUser_phone("spring_test");
		user.setUser_birth("spring_test");
		user.setUser_email("sping_test");
		
		usermapper.insert(user);
		
	}
	
}
