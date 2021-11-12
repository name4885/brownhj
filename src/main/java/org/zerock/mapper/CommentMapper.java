package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.CommentVO;

public interface CommentMapper {
	//댓글쓰기(insert)   - Create
	public int insert(CommentVO vo);
	//댓글상세페이지(select)  - Read
	public CommentVO read (int co_num);
	//댓글삭제(delete)
	public int delete(int co_num);
	//댓글수정(update)	
	public int update(CommentVO vo);
	// 댓글목록리스트
	public List<CommentVO> getListWithPaging(@Param("cri") Criteria cri,
											@Param("bo_num") int bo_num);
	public int getCountByBo_num(int bo_num);
	
	
	
}
