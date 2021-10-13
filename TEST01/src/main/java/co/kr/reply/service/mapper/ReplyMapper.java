package co.kr.reply.service.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReplyMapper {

	public List<HashMap<String, Object>> list(int board_no);

	public int replyUp();

	public int insert(HashMap<String, Object> param);

	public int delete(int reply_no);

	public int modify(HashMap<String, Object> param);

}
