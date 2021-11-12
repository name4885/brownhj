package org.zerock.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/hobbyboard/*")  
public class BoardController {
	
	private BoardService service;
	
	// 게시물 목록
//	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	@GetMapping("list")
	public void list(Model model, Criteria cri) {
		log.info("list");
		int total=service.getTotalCount(cri);
		//				     배열이름, select된 결과물
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri,total));
	}
	@GetMapping("read")
	public void read(long bo_num, Model model) {
		log.info("read......" + bo_num);
		service.get(bo_num);
		model.addAttribute("read",service.get(bo_num));
	}
	//글쓰기 화면으로 이동하기 위해
	@GetMapping("register")
	public void register() {
		log.info("register");
	}
	//글쓰기 화면에서 글쓰기 버튼을 클릭했을 때 제목, 내용, 작성자를 처리하기 위해
	@PostMapping("register")
	public String registerPost(BoardVO board, RedirectAttributes rttr) {
		log.info("register 하기전" +board);
		service.register(board);//글쓰기 한 후
		rttr.addAttribute("bo_num",board.getBo_num());
//		log.info("register 한 후" + hobbyboard);
		return "redirect:/hobbyboard/read"; // board/read.jsp로 화면이동
	}
	//글수정 화면으로 이동하기 위해
	@GetMapping("modify")
	public void modifyGet(long bo_num, Model model) {
		log.info("modify");
		model.addAttribute("modify",service.get(bo_num));
	}
	@PostMapping("modify")
	public String modifyPost(BoardVO board, RedirectAttributes rttr,Model model) {
		log.info("modifyPost : " + board);
		service.modify(board);
//		model.addAttribute("result",service.modify(board));
		rttr.addAttribute("bo_num",board.getBo_num());
		
		return "redirect:/hobbyboard/read";
	}
	@GetMapping("remove")
	public String remove(long bo_num) {
		log.info("remove : " + bo_num);
		service.remove(bo_num);
		return "redirect:/hobbyboard/list";
	}
}
