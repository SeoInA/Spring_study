package com.study.regist.Dao;

import com.study.regist.Dto.LoginDTO;
import com.study.regist.Dto.UserVO;

public interface UserDAO {
	
	public void insertUser(UserVO uservo) throws Exception; /* 유저생성 */
    
	public UserVO login(LoginDTO loginDTO) throws Exception; /* 로그인 */
		
	public void modify(LoginDTO loginDTO) throws Exception; /* 회원수정 */
		
	public void withdrawal(LoginDTO loginDTO) throws Exception; /* 회원탈퇴 */

}
