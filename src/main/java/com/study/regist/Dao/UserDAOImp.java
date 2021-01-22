package com.study.regist.Dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.regist.Dto.LoginDTO;
import com.study.regist.Dto.UserVO;

@Repository
public class UserDAOImp implements UserDAO {

	@Autowired
	private SqlSession session;
	
	private static String namespace = "com.popit.mapper.UserMapper";
	
	@Override
	public void insertUser(UserVO uservo) throws Exception {
		session.insert(namespace +".insertUser", uservo);
	}

	@Override
	public UserVO login(LoginDTO loginDTO) throws Exception {
		return session.selectOne(namespace +".login", loginDTO);
	}

	@Override
	public void modify(LoginDTO loginDTO) throws Exception {
		session.update(namespace +".modify", loginDTO);
	}

	@Override
	public void withdrawal(LoginDTO loginDTO) throws Exception {
		session.delete(namespace +".withdrawal", loginDTO);
	}	

}
