package co.kr.like.service.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikeMapper {

	public int likeCnt(int board_no);

	public int likeMax();

	public List<HashMap<String, Object>> list(int board_no);

	public int insert(HashMap<String, Object> param);
	
	public int likeBtn(HashMap<String, Object> param);

	public int delete(HashMap<String, Object> param);


}
