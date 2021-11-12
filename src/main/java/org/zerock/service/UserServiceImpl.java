package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.Criteria;
import org.zerock.domain.CommentVO;
import org.zerock.domain.UserVO;
import org.zerock.domain.commentPageDTO;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.CommentMapper;
import org.zerock.mapper.UserMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	
	private UserMapper mapper;
	
	public void register(UserVO user) {
		mapper.insert(user);
	}

	public UserVO get(String user_id) {
		return mapper.read(user_id);
	}
	
	public int remove(String user_id) {
		return mapper.delete(user_id);
	}

	public int modify(UserVO user) {
		return mapper.update(user);
	}


}
