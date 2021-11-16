package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{
	
	//@Autowired
	//UserMapper usermapper;   == 	private UserMapper mapper;
	
	private UserMapper usermapper;

	public void insert(UserVO user) {
		 usermapper.insert(user);
	}

	public UserVO get(String user_id) {
		return usermapper.read(user_id);
	}
	
	public int remove(String user_id) {
		return usermapper.delete(user_id);
	}

	public int modify(UserVO user) {
		return usermapper.update(user);
	}


}
