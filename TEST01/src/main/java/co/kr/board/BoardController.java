package co.kr.board;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.kr.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	public BoardService boardService;
	//------------------------------리스트---------------------------------
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(HttpSession session,Model model) {
		int user_no = Integer.parseInt(session.getAttribute("user_no").toString());
		model.addAttribute("user_no", user_no);
		return "board/list";
	}
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public ModelAndView home_ajax(int page, String keyword, String type) {
		ModelAndView json = new ModelAndView("jsonView");
		List<HashMap<String, Object>> list = boardService.list(page,keyword,type);
		
		int endPage = (int)(Math.ceil(page*1.0/10))*10;
		int startPage = endPage - 9;
		if(startPage <= 0) {
			startPage = 1;
		}
		
		int total = boardService.total(keyword,type);
		int totalPage = (int)(Math.ceil(total*1.0/10));
		
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
		boolean prev = page > 1;
		boolean next = page < endPage;
		
		json.addObject("list", list);
		json.addObject("endPage", endPage);
		json.addObject("startPage", startPage);
		json.addObject("prev", prev);
		json.addObject("next", next);
		return json;
	}
	//--------------------------------게시글 추가-------------------------------
	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.GET)
	public String insert(Model model,HttpSession session) {
		int user_no = Integer.parseInt(session.getAttribute("user_no").toString());
		int max = boardService.max();
		model.addAttribute("user_no", user_no);
		model.addAttribute("max", max+1);
		return "board/insert";
	}
	@RequestMapping(value = "/BoardInsert.do", method = RequestMethod.POST)
	public ModelAndView insert_board(@RequestParam HashMap<String, Object> param) {
		ModelAndView json = new ModelAndView("jsonView");
		boardService.insert(param);
		return json;
	}
	//-----------------------------게시물 상세보기--------------------------------
	@RequestMapping(value = "/BoardDetail.do", method = RequestMethod.GET)
	public String detail(Model model,int board_no,HttpSession session) {
		HashMap<String, Object> detail = boardService.detail(board_no);
		
		boardService.cntUp(detail);
		
		model.addAttribute("nick", session.getAttribute("user_nick"));
		model.addAttribute("vo", detail);
		return "board/detail";
	}
	
	//------------------------------게시물 삭제-----------------------------------
	@RequestMapping(value = "/BoardDelete.do", method = RequestMethod.POST)
	public ModelAndView delete(int board_no) {
		ModelAndView json = new ModelAndView("jsonView");
		boardService.delete(board_no);
		return json;
	}
	//------------------------------게시물 삭제-----------------------------------
	@RequestMapping(value = "/BoardModify.do", method = RequestMethod.GET)
	public String modify(int board_no, Model model) {
		HashMap<String, Object> param = boardService.detail(board_no);
		model.addAttribute("vo", param);
		return "board/modify";
	}
	@RequestMapping(value = "/ModifyBoard.do", method = RequestMethod.POST)
	public ModelAndView modify_ajax(@RequestParam HashMap<String, Object> param) {
		ModelAndView json = new ModelAndView("jsonView");
		boardService.modify(param);
		return json;
	}
}
