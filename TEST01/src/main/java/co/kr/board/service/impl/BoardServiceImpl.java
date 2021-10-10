package co.kr.board.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.board.service.BoardService;
import co.kr.board.service.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	public BoardMapper boardMapper;

	@Override
	public List<HashMap<String, Object>> list(int page, String keyword, String type) {
		int amount = 10;
		HashMap<String, Object> list = new HashMap<String, Object>();
		list.put("startRn", (page-1)*10);
		list.put("endRn", page*10);
		list.put("type", type);
		list.put("keyword", keyword);
		return boardMapper.list(list);
	}

	@Override
	public int total(String keyword, String type) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("type", type);
		param.put("keyword", keyword);
		return boardMapper.total(param);
	}

	@Override
	public int max() {
		return boardMapper.max();
	}

	@Override
	public int insert(HashMap<String, Object> param) {
		SimpleDateFormat simple = new SimpleDateFormat("yyyy.MM.dd");
		Date date = new Date();
		param.put("board_day", simple.format(date));
		return boardMapper.insert(param);
	}

	@Override
	public HashMap<String, Object> detail(int board_no) {
		return boardMapper.detail(board_no);
	}

	@Override
	public int delete(int board_no) {
		return boardMapper.delete(board_no);
	}

	@Override
	public int cntUp(HashMap<String, Object> detail) {
		detail.put("board_view", Integer.parseInt(detail.get("BOARD_VIEW").toString())+1);
		detail.put("board_no", Integer.parseInt(detail.get("BOARD_NO").toString()));
		return boardMapper.cntUp(detail);
	}

	@Override
	public int modify(HashMap<String, Object> param) {
		return boardMapper.modify(param);
	}
}
