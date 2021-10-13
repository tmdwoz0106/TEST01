package co.kr.like;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.kr.like.service.LikeService;

@Controller
public class LikeController {

	@Autowired
	public LikeService likeService;

	@RequestMapping(value = "/like.do", method = RequestMethod.POST)
	public ModelAndView Like_modify(@RequestParam HashMap<String, Object> param) {
		ModelAndView json = new ModelAndView("jsonView");

		likeService.insert(param);
		
		return json;
	}
	
	@RequestMapping(value = "/likeDelete.do", method = RequestMethod.POST)
	public ModelAndView Like_delete(int board_no,int user_no) {
		ModelAndView json = new ModelAndView("jsonView");
		
		likeService.delete(board_no,user_no);
		
		return json;
	}
	@RequestMapping(value = "/likeSu.do", method = RequestMethod.GET)
	public ModelAndView Like_su(int board_no) {
		ModelAndView json = new ModelAndView("jsonView");
		
		int su = likeService.likeCnt(board_no);
		json.addObject("su", su);
		return json;
	}
}