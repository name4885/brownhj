package org.zerock.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.UserVO;
import org.zerock.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/join/*")   
public class UserController {
	
	private UserService userservice;
	
	//회원정보
	@GetMapping("info")
	public void read(String user_id) {
		log.info("info" + user_id);
//		service.get(user_id);
	}
	
	//회원가입창으로 이동	
	@GetMapping("membership")
	public void register(UserVO user) {
		log.info("membership");
//		service.register(user);
	}
	
	//회원가입
	@RequestMapping(value="membership", method=RequestMethod.POST)
	public String membershipPOST(UserVO user) throws Exception{
		
		log.info("join 진입");
		
		// 회원가입 서비스 실행
		userservice.insert(user);
		
		log.info("join Service 성공");
		
		return "redirect:/#";
		
	}


	//회원 정보 수정
	@GetMapping("edit")
	public void modify(UserVO user) {
		log.info("edit");
//		service.modify(user);
	}

	@GetMapping("MBout")
	public String remove(String user_id) {
		log.info("remove : " + user_id);
//		service.remove(user_id);
		return "/#";
		//탈퇴 알림창을 띄운후 홈화면으로
	}
}
