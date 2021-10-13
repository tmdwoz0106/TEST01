package co.kr.reply;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.kr.reply.service.ReplyService;

@Controller
public class ReplyController {

	@Autowired
	public ReplyService replyService;
	
	//---------------------------------------댓글 추가------------------------------------
	@RequestMapping(value = "/insertReply.do", method = RequestMethod.GET)
	public String ReplyInsert(@RequestParam HashMap<String, Object> param, Model model) {
		replyService.insert(param);
		
		return "redirect:/BoardDetail.do?board_no="+Integer.parseInt(param.get("board_no").toString());
	}
	
	@RequestMapping(value = "/inserttype.do", method = RequestMethod.GET)
	public String typeInsert(@RequestParam HashMap<String, Object> param, Model model) {
		replyService.insert(param);
		
		return "redirect:/typeDetail.do?board_no="+Integer.parseInt(param.get("board_no").toString());
	}
	//---------------------------------------댓글 삭제------------------------------------
	@RequestMapping(value = "/replyDelete.do", method = RequestMethod.POST)
	public ModelAndView reply_delete(int reply_no) {
		ModelAndView json = new ModelAndView("jsonView");
		replyService.delete(reply_no);
		return json;
	}
	
	@RequestMapping(value = "/typeDelete.do", method = RequestMethod.POST)
	public ModelAndView type_delete(int reply_no) {
		ModelAndView json = new ModelAndView("jsonView");
		replyService.delete(reply_no);
		return json;
	}
	//---------------------------------------댓글 수정------------------------------------
	@RequestMapping(value = "/replyModify.do", method = RequestMethod.GET)
	public String modify(@RequestParam HashMap<String, Object> param) {
		replyService.modify(param);
		return "redirect:/BoardDetail.do?board_no="+Integer.parseInt(param.get("board_no").toString());
	}
	
	@RequestMapping(value = "/typeModify.do", method = RequestMethod.GET)
	public String Typemodify(@RequestParam HashMap<String, Object> param) {
		replyService.modify(param);
		return "redirect:/typeDetail.do?board_no="+Integer.parseInt(param.get("board_no").toString());
	}
}
