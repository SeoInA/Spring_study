package com.study.regist.Service;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.regist.Dao.UserDAO;
import com.study.regist.Dto.LoginDTO;
import com.study.regist.Dto.UserVO;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserDAO userdao;
	
	@Override
	public void insertUser(UserVO uservo) throws Exception {
		userdao.insertUser(uservo);
	}

	@Override
	public UserVO login(LoginDTO loginDTO) throws Exception {
		return userdao.login(loginDTO);
	}

	@Override
	public void modify(LoginDTO loginDTO) throws Exception {
		userdao.modify(loginDTO);
	}

	@Override
	public void withdrawal(LoginDTO loginDTO) throws Exception {
		userdao.withdrawal(loginDTO);
	}

}
