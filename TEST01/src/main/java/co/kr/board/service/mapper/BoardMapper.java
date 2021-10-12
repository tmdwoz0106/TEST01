package co.kr.board.service.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {

	public List<HashMap<String, Object>> list(HashMap<String, Object> list);

	public int total(HashMap<String, Object> param);

	public int max();

	public int insert(HashMap<String, Object> param);

	public HashMap<String, Object> detail(int board_no);

	public int delete(int board_no);

	public int cntUp(HashMap<String, Object> detail);

	public int modify(HashMap<String, Object> param);

	public List<HashMap<String, Object>> typeList(HashMap<String, Object> param);

	public int typeTotal(HashMap<String, Object> param);

	public HashMap<String, Object> typeDetail(int board_no);

}
