package com.study.regist.Controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.regist.Dto.LoginDTO;
import com.study.regist.Dto.UserVO;
import com.study.regist.Service.UserService;

@Controller
@RequestMapping("/")
public class UserLoginController {
	
	@Autowired
	private final UserService userService;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public UserLoginController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String LoginGET(@ModelAttribute("loginDTO") LoginDTO loginDTO) {
		return "/regist/login";
	}
	
	@RequestMapping(value="/loginPost", method=RequestMethod.POST)
	public void loginPOST(LoginDTO loginDTO, HttpSession httpsession, Model model) throws Exception{
		UserVO uservo = userService.login(loginDTO);
		
		if(uservo == null || !passwordEncoder.matches(loginDTO.getPassword(), uservo.getPassword())) {
			return;
		}
		model.addAttribute("userVO", uservo);
	}
    
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession httpsession) throws Exception{
		Object object = httpsession.getAttribute("login");
		if(object != null) {
			httpsession.removeAttribute("login");
			httpsession.invalidate();
		}
		return "/regist/logout";
	}
}