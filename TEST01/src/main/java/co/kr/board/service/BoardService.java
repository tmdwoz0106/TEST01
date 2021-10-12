package co.kr.board.service;

import java.util.HashMap;
import java.util.List;

public interface BoardService {

	public List<HashMap<String, Object>> list(int page, String keyword, String type);

	public int total(String keyword, String type);

	public int max();

	public int insert(HashMap<String, Object> param);

	public HashMap<String, Object> detail(int board_no);

	public int delete(int board_no);

	public int cntUp(HashMap<String, Object> detail);

	public int modify(HashMap<String, Object> param);

	public List<HashMap<String, Object>> typeList(String board_type,int page, String type, String keyword);

	public int typeTotal(String board_type,String type, String keyword);


	public HashMap<String, Object> typeDetail(int board_no);



}
