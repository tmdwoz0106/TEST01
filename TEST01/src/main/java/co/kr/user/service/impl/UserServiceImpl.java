package co.kr.user.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import co.kr.security.VO.UserVO;
import co.kr.user.service.UserService;
import co.kr.user.service.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	public UserMapper userMapper;
	
	@Resource(name = "passwordEncoder")
	ShaPasswordEncoder passwordEncoder;

	@Override
	public HashMap<String, Object> list(HashMap<String, Object> param, HttpSession session) {
		String id = (String)param.get("user_id");
		String pw = (String)param.get("user_pw");
		int i = userMapper.idCheck(id);
		if(i > 0) {
			param = userMapper.login(param);
			if(param == null) {
				param = new HashMap<String, Object>();
				param.put("mag", "잘못된 비밀번호입니다.");
				return param;
			}else {
				session.setAttribute("user_id", id);
				session.setAttribute("user_nick", param.get("USER_NICK"));
				session.setAttribute("user_no", param.get("USER_NO"));
				return param;
			}
		}else {
			param = new HashMap<String, Object>();
			param.put("msg", "없는 아이디입니다");
			return param;
		}
	}

	@Override
	public int max() {
		return userMapper.cnt();
	}

	@Override
	public int join(UserVO vo) {
		vo.setUser_pw(passwordEncoder.encodePassword(vo.getUser_pw(), vo.getUser_id()));
		return userMapper.join(vo);
	}

	@Override
	public int delete(int user_no) {
		return userMapper.delete(user_no);
	}

	@Override
	public HashMap<String, Object> detail(int user_no) {
		return userMapper.detail(user_no);
	}

	@Override
	public int modify(HashMap<String, Object> param, HttpSession session) {
		List<HashMap<String, Object>> list = userMapper.userCheck();
		for(int i = 0; i < list.size(); i++) {
			if(param.get("user_id").equals(list.get(i).get("USER_ID"))) {
				return (int) 0.5;
			}else if(param.get("user_nick").equals(list.get(i).get("USER_NICK"))) {
				return 0;
			}else {				
				session.setAttribute("user_nick", param.get("user_nick"));
			}
		}
		return userMapper.modify(param);
	}

	@Override
	public HashMap<String, Object> IdFinde(HashMap<String, Object> param) {
//		param.put("msg", param.get("user_id"));
//		param.put("msg", param.get("user_pw"));
		return userMapper.IdFind(param);
	}


}
