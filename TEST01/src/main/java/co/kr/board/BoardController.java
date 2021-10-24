package co.kr.board;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import co.kr.board.service.BoardService;
import co.kr.file.service.FileService;
import co.kr.like.service.LikeService;
import co.kr.reply.service.ReplyService;
import co.kr.security.VO.UserVO;

@Controller
public class BoardController {

	@Autowired
	public BoardService boardService;

	@Autowired
	public ReplyService replyService;
	
	@Autowired
	public LikeService likeService;
	
	@Autowired
	public FileService fileService;

	@Resource(name = "uploadPath")
	String uploadPath;
	//------------------------------리스트---------------------------------
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(HttpSession session,Model model) {
		
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
	public String insert_board(@RequestParam HashMap<String, Object> param, MultipartFile[] file)throws IOException {
//		String fileName = file.getOriginalFilename();
//		File target = new File(uploadPath,fileName);
//		System.out.println("파일 이름 = "+fileName);
//		FileCopyUtils.copy(file.getBytes(),target );
//		param.put("path", uploadPath + "\\" + fileName);
//		param.put("upload_name", fileName);
		int uploadMax = fileService.uploadMax();
		
		for(int i = 0; i < file.length; i++) {
			param.put("uploadMax", uploadMax+i+1);

			String fileName = file[i].getOriginalFilename();
			System.out.println("파일 이름 : " + fileName);
			File target = new File(uploadPath,fileName);
			FileCopyUtils.copy(file[i].getBytes(),target );
			
			String filePath = uploadPath +"\\" + fileName; 
			
			param.put("upload_name", fileName);
			param.put("upload_path", filePath);
			System.out.println(param);
			fileService.insert(param);
		}
		boardService.insert(param);
		return "redirect:/home.do";
	}
	//-----------------------------게시물 상세보기--------------------------------
	@RequestMapping(value = "/BoardDetail.do", method = RequestMethod.GET)
	public String detail(Model model,int board_no,HttpSession session,Authentication authentication) {
		HashMap<String, Object> detail = boardService.detail(board_no);
		List<MultipartFile> Filelist = fileService.FileList(board_no);
		int likeCnt = likeService.likeCnt(board_no);
		
		boardService.cntUp(detail);
		int likeMax = likeService.likeMax();
		
		List<HashMap<String, Object>> list = replyService.list(board_no);
		HashMap<String, Object> param = new HashMap<String, Object>();
		int replyUp = replyService.replyUp();
		UserVO user = (UserVO)authentication.getPrincipal();
		
		int user_no = user.getUser_no();
				
		param.put("board_no", board_no);
		param.put("user_no", user_no);
		int likeBtn = likeService.likeBtn(param);
		
		model.addAttribute("fileList", Filelist);
		model.addAttribute("likeBtn", likeBtn);
		model.addAttribute("likeMax", likeMax+1);
		model.addAttribute("like", likeCnt);
		model.addAttribute("user_no", user_no);
		model.addAttribute("list", list);
		model.addAttribute("max", replyUp+1);
		model.addAttribute("nick", session.getAttribute("user_nick"));
		model.addAttribute("vo", detail);
		return "board/detail";
	}
	
	//------------------------------게시물 삭제-----------------------------------
	@RequestMapping(value = "/BoardDelete.do", method = RequestMethod.POST)
	public ModelAndView delete(int board_no) {
		ModelAndView json = new ModelAndView("jsonView");
		fileService.delete(board_no);
		boardService.delete(board_no);
		return json;
	}
	//------------------------------게시물 수정-----------------------------------
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
	//-----------------------------2021년 10월12일 오후 5시43분-------------------
	//-----------------------------타입별 게시물
	//-------------------------------게시물 타입별--------------------------------
	@RequestMapping(value = "/BoardType.do", method = RequestMethod.GET)
	public String BoardDetail(String board_type,Model model) {
		model.addAttribute("board_type", board_type);
		return "board/type";
	}
	@RequestMapping(value = "/TypeBoard.do", method = RequestMethod.GET)
	public ModelAndView BoardDetail_ajax(String board_type,int page, String type, String keyword) {
		ModelAndView json = new ModelAndView("jsonView");
		List<HashMap<String, Object>> list = boardService.typeList(board_type,page,type,keyword);
		
		int endPage = (int)(Math.ceil(page*1.0/5))*5;
		int startPage = endPage - 4;
		if(startPage <= 0) {
			startPage = 1;
		}

		int total = boardService.typeTotal(board_type,type, keyword);
		int totalPage = (int)(Math.ceil(total*1.0/5));
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
	//-----------------------------------타입 상세보기------------------------------
	@RequestMapping(value = "/typeDetail.do", method = RequestMethod.GET)
	public String TypeDetail(int board_no,Model model,HttpSession session) {
		int user_no = Integer.parseInt(session.getAttribute("user_no").toString());
		String user_nick = (String)session.getAttribute("user_nick");
		HashMap<String, Object> detail = boardService.typeDetail(board_no);
		List<HashMap<String, Object>> list = replyService.list(board_no);
		boardService.cntUp(detail);
		
		int likeCnt = likeService.likeCnt(board_no);
		int replyMax = replyService.replyUp();
		int likeCheck = likeService.likeCheck(board_no,user_no);
		int likeMax = likeService.likeMax();

		model.addAttribute("likeMax", likeMax+1);
		model.addAttribute("likeCheck", likeCheck);
		model.addAttribute("likeCnt", likeCnt);
		model.addAttribute("list", list);
		model.addAttribute("max", replyMax+1);
		model.addAttribute("user_no", user_no);
		model.addAttribute("user_nick", user_nick);
		model.addAttribute("vo", detail);
		return "board/typeDetail";
	}
	
}
