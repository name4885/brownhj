package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class CommentVO {
	//댓글번호
	private int co_num;
	//게시판 번호
	private int bo_num;
	//댓글내용
	private String co_text;
	//댓글작성자
	private String user_id;
	//댓글작성일
	private Date co_date;
	//댓글수정일
	private Date co_update;
}
