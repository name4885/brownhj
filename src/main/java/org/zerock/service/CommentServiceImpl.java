package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.Criteria;
import org.zerock.domain.CommentVO;
import org.zerock.domain.commentPageDTO;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.CommentMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService{
	
	private CommentMapper mapper;
	private BoardMapper boardmapper;
	//댓글쓰기
	
	@Transactional
	@Override
	public int register(CommentVO vo) {
		boardmapper.updateCommentCnt(vo.getBo_num(), 1);
		return mapper.insert(vo);
	}
	//댓글상세페이지
	@Override
	public CommentVO get(int co_num) {
		return mapper.read(co_num);
	}
	//댓글삭제
	@Transactional
	@Override
	public int remove(int co_num) {
		CommentVO vo=mapper.read(co_num);
		boardmapper.updateCommentCnt(vo.getBo_num(), -1);
		return mapper.delete(co_num);
	}
	//댓글수정
	@Override
	public int modify(CommentVO vo) {
		return mapper.update(vo);
	}
	//댓글목록리스트
	@Override
	public commentPageDTO getListWithPaging(Criteria cri, int bo_num) {
		return new commentPageDTO(	
				mapper.getCountByBo_num(bo_num),
				mapper.getListWithPaging(cri, bo_num));
	}


}
