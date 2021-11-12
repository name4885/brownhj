package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	//게시판 번호
	private int bo_num;
	//아이디
	private String user_id;
	//제목
	private String bo_title;
	//게시글 내용
	private String bo_text;
	//게시글 날짜
	private Date bo_date;
	//수정일자
	private Date bo_update;
	//취미번호
	private int hb_no;
	//지역번호
	private int lo_no;
	//댓글번호
	private int co_no;
	//댓글 수
	private int ctCnt;
}
