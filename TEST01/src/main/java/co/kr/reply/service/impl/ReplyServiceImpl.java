package co.kr.reply.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.reply.service.ReplyService;
import co.kr.reply.service.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	public ReplyMapper replyMapper;

	@Override
	public List<HashMap<String, Object>> list(int board_no) {
		return replyMapper.list(board_no);
	}

	@Override
	public int replyUp() {
		return replyMapper.replyUp();
	}

	@Override
	public int insert(HashMap<String, Object> param) {
		SimpleDateFormat simple = new SimpleDateFormat("yyyy.MM.dd");
		Date date = new Date();
		param.put("reply_day", simple.format(date));
		return replyMapper.insert(param);
	}

	@Override
	public int delete(int reply_no) {
		return replyMapper.delete(reply_no);
	}

	@Override
	public int modify(HashMap<String, Object> param) {
		return replyMapper.modify(param);
	}

}
