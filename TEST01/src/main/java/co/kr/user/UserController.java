package co.kr.user;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.kr.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	public UserService userService;
	//-------------------------------로그인 페이지-------------------------------
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login() {
		
		return "user/login";
	}
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView login_ajax(@RequestParam HashMap<String, Object> param,HttpSession session) {
		ModelAndView json = new ModelAndView("jsonView");
		
		json.addObject("result", userService.list(param,session));
		return json;
	}
	//-----------------------------------로그아웃--------------------------------
	@RequestMapping(value = "/logout.do", method = RequestMethod.POST)
	public ModelAndView logout(HttpSession session) {
		ModelAndView json = new ModelAndView("jsonView");
		session.invalidate();
		return json;
	}
	//--------------------------------회원 가입-------------------------------------
	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public String insert(Model model) {
		int max = userService.max();
		model.addAttribute("max", max+1);
		return "user/join";
	}
	@RequestMapping(value = "/joinus.do", method = RequestMethod.POST)
	public ModelAndView join(@RequestParam HashMap<String, Object> param) {
		ModelAndView json = new ModelAndView("jsonView");
		if(userService.join(param)>0) {
			json.addObject("msg", "회원가입 성공");
			json.addObject("result", "1");
		}else {
			json.addObject("msg", "이미 등록된 아이디입니다");
			json.addObject("result", "2");
		}
		
		return json;	
	}
	//--------------------------------회원 정보-------------------------------------
	@RequestMapping(value = "/UserDetail.do", method = RequestMethod.GET)
	public String Detail(int user_no, Model model) {
		HashMap<String, Object> param = userService.detail(user_no);
		
		model.addAttribute("vo", param);
		return "user/detail";
	}
	//-------------------------------회원 탈퇴----------------------------------------
	@RequestMapping(value = "/UserDelete.do", method = RequestMethod.POST)
	public ModelAndView delete(int user_no) {
		ModelAndView json = new ModelAndView("jsonView");
		userService.delete(user_no);
		return json;
	}
	//-------------------------------회원 정보수정----------------------------------------
	@RequestMapping(value = "/UserModify.do", method = RequestMethod.GET)
	public String modify(int user_no,Model model) {
		HashMap<String, Object> param = userService.detail(user_no);
		model.addAttribute("vo",param);
		return "user/modify";
	}
	@RequestMapping(value = "/MoidfyUser.do", method = RequestMethod.POST)
	public ModelAndView modify_ajax(@RequestParam HashMap<String, Object> param, HttpSession session) {
		ModelAndView json = new ModelAndView("jsonView");
		if(userService.modify(param, session)>0) {
			
			json.addObject("msg", "정보 수정 완료!");
			json.addObject("result", 1);
		}else if(1>userService.modify(param, session)&&userService.modify(param, session)>0) {
			json.addObject("msg", "이미 사용중인 아이디입니다.");
			json.addObject("result", 2);
		}else {
			json.addObject("msg", "이미 사용중인 닉네임입니다.");
			json.addObject("result", 2);
		}
		
		return json;
	}
}
