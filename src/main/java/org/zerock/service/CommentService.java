package org.zerock.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.CommentVO;
import org.zerock.domain.commentPageDTO;

public interface CommentService {
	//댓글쓰기(insert)   - Create
	public int register(CommentVO vo);
	//댓글상세페이지(select)  - Read
	public CommentVO get (int co_num);
	//댓글삭제(delete)	  - Update
	public int remove(int co_num);
	//댓글수정(update)	  - Delete
	public int modify(CommentVO vo);
	//댓글목록리스트
	public commentPageDTO getListWithPaging(Criteria cri, int bo_num);
}
