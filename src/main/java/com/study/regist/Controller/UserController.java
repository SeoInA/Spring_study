package com.study.regist.Controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.regist.Dto.LoginDTO;
import com.study.regist.Dto.UserVO;
import com.study.regist.Service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private UserService userservice;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String goToMain() throws Exception {
		return "/main";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String RegisterGET() throws Exception {
		return "/regist/register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String RegisterPost(UserVO uservo, RedirectAttributes rttr) throws Exception{
		/*
		 * BCrypt라는 새로운 기능이 있는데 이건 비밀번호를 암호화해서 저장해주는 기능입니다.
		 * 그걸 hasedPw라는 변수에 담아 setPassword를 해주고 유저를 생성합니다.
		 */
		String hashedPw = passwordEncoder.encode(uservo.getPassword());
		uservo.setPassword(hashedPw);
		userservice.insertUser(uservo);
		rttr.addFlashAttribute("msg", "Registered");
	
		return "redirect:/regist/login";
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String ProfileGET() throws Exception {
		return "/regist/profile";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String ModifyGET() throws Exception {
		
		return "/regist/modify";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String ModifyPOST(HttpSession httpsession, RedirectAttributes rttr, LoginDTO loginDTO) throws Exception {
		userservice.modify(loginDTO);
		
		httpsession.invalidate(); //httpsession.invalidate는 세션을 삭제하지는 않지만 무효화 해준다.
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/withdrawal", method = RequestMethod.GET)
	public String WithdrawalGET() throws Exception {
		return "/regist/withdrawal";
	}
	
	@RequestMapping(value = "/withdrawal", method = RequestMethod.POST)
	public String WithdrawalPOST(HttpSession httpsession, RedirectAttributes rttr, LoginDTO loginDTO) throws Exception {
		userservice.withdrawal(loginDTO);
		httpsession.invalidate();
		
		return "redirect:/";
	}
}
