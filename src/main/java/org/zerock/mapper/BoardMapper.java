package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {// 인터페이스 
	
	
	
	//추상매서드(게시판 목록  리스트)
	public List<BoardVO> getList();
	
	// 게시판 목록 리스트(paging처리 된거)
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);
	
	
	// 추상메서드(게시판 글쓰기) - insert만 처리되고 생성된 pk값을 알 필요가 없는 경우(단순 게시글 쓰기)
	public void insert(BoardVO board);
	
	// 추상메서드(게시판 글쓰기) - insert문이 실행되고 생성된 pk값을 알아야 하는 경우(게시글 쓰기 + 첨부파일)
	public void insertSelectKey(BoardVO board);
	
	// 추상메서드(게시판 목록 리스트에서 제목을 클릭한 후 나오는 상세페이지 조회)
	public BoardVO read(Long bo_num);
	
	// 추상메서드(게시판 글삭제)
	public int delete(Long bo_num);
	
	// 추상메서드(게시판 글수정)
	public int update(BoardVO board);
	
	public void updateCommentCnt(@Param("bo_num")int bo_num,@Param("amount") int amount);

	
	
	
}
