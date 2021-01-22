package com.study.regist.Service;

import com.study.regist.Dto.LoginDTO;
import com.study.regist.Dto.UserVO;

public interface UserService {
	
	public void insertUser(UserVO uservo) throws Exception;
	
	public UserVO login(LoginDTO loginDTO) throws Exception;
	
	public void modify(LoginDTO loginDTO) throws Exception;
	
	public void withdrawal(LoginDTO loginDTO) throws Exception;

}
