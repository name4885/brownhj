package org.zerock.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.CommentVO;
import org.zerock.domain.UserVO;
import org.zerock.domain.commentPageDTO;

public interface UserService {
	// (회원가입) - Create
	public void register(UserVO user);
	
	// (회원 정보 조회)  - Read
	public UserVO get (String user_id);
	
	// (회원탈퇴)  - delete
	public int remove(String user_id);
	
	// (회원정보수정) - update
	public int modify(UserVO user);
}
