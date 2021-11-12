package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j //log.info를 console창에 보여주기 위해
@Service //비지니스 적인 클래스라는걸 자바에서 이해하도록 하기 위해서
@AllArgsConstructor // @Setter(onMethod_= {@Autowired})이걸 안쓰는 대신 생성자 생성하기 위해
public class BoardServiceImpl implements BoardService{
	
	//@Setter(onMethod_= {@Autowired}) spring 4.3 이상에서 자동 처리
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) {
		log.info("register...."+board);
		
		mapper.insertSelectKey(board); //2단계랑 3단계를 이어주기 위해
	}
	@Override
	public BoardVO get(Long bo_num) {
		log.info("register....."+bo_num);
		return mapper.read(bo_num);
	}
 
	@Override
	public boolean modify(BoardVO board) {
		log.info("modify....."+ board);
		return mapper.update(board)==1;
	}

	@Override
	public boolean remove(Long bo_num) {
		log.info("modify....."+ bo_num);
		return mapper.delete(bo_num)==1;
	}

//	@Override
//	public List<BoardVO> getList() {
//		log.info("getList......");
//		return mapper.getList();
//	}
	@Override
	public List<BoardVO> getList(Criteria cri){
		log.info("getList......");
		return mapper.getListWithPaging(cri);
	}
	@Override
	public int getTotalCount(Criteria cri) {
		log.info("getTotalCount......");
		return mapper.getTotalCount(cri);
	}
}
