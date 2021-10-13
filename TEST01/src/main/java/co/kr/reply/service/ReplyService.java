package co.kr.reply.service;

import java.util.HashMap;
import java.util.List;

public interface ReplyService {

	public List<HashMap<String, Object>> list(int board_no);

	public int replyUp();

	public int insert(HashMap<String, Object> param);

	public int delete(int reply_no);

	public int modify(HashMap<String, Object> param);

}
