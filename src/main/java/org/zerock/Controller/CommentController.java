package org.zerock.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criteria;
import org.zerock.domain.CommentVO;
import org.zerock.domain.commentPageDTO;
import org.zerock.service.CommentService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@AllArgsConstructor
@RequestMapping("/replies")
public class CommentController {
	public CommentService service;
	
	
	
	
	//댓글 쓰기!!
	@PostMapping(value="new",consumes="application/json",produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody CommentVO vo){
		return service.register(vo)==1?new ResponseEntity<>("success",HttpStatus.OK)
							:new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	//댓글 리스트!!
	@GetMapping(value="pages/{bo_num}/{page}",produces= {MediaType.APPLICATION_JSON_UTF8_VALUE,
														MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<commentPageDTO> getList(@PathVariable("bo_num") int bo_num,@PathVariable("page") int page){
		Criteria cri = new Criteria(page,10);
		return new ResponseEntity<>(service.getListWithPaging(cri, bo_num),HttpStatus.OK);
	}
	
	
	
	//댓글 상세페이지!!
	@GetMapping(value="/{co_num}", produces= {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<CommentVO> get(@PathVariable("co_num") int co_num){
		return new ResponseEntity<>(service.get(co_num),HttpStatus.OK);
	}
	
	
	
	//댓글 삭제!!
	@DeleteMapping(value="/{co_num}", produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("co_num") int co_num){
		int removecount =service.remove(co_num);
		return removecount==1?new ResponseEntity<>("success",HttpStatus.OK)
				:new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	//댓글 수정!!
	@PutMapping(value="/{co_num}",produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@PathVariable("co_num") int co_num ,@RequestBody CommentVO vo){
		vo.setCo_num(co_num); 
		service.modify(vo);
		return service.modify(vo)==1?new ResponseEntity<>("success",HttpStatus.OK)
				:new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	} 
}
