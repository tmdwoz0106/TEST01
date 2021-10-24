package co.kr.user.service;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import co.kr.security.VO.UserVO;

public interface UserService {

	public HashMap<String, Object> list(HashMap<String, Object> param, HttpSession session);

	public int max();

	public int join(UserVO vo);

	public int delete(int user_no);

	public HashMap<String, Object> detail(int user_no);

	public int modify(HashMap<String, Object> param, HttpSession session);

	public HashMap<String, Object> IdFinde(HashMap<String, Object> param);



}
