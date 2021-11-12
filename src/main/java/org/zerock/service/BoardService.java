package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService {
	// 게시판 글쓰기
	public void register(BoardVO board);
	// 게시판 상세페이지
	public BoardVO get(Long bo_num);
	// 게시판 글 수정
	public boolean modify(BoardVO board);
	// 게시판 글 삭제
	public boolean remove(Long bo_num);
	// 게시판 목록 리스트
//	public List<BoardVO> getList();
	// 게시판 목록리스트 (페이징 처리 된거)
	public List<BoardVO> getList(Criteria cri);
	//게시판 갯수
	public int getTotalCount(Criteria cri);
}