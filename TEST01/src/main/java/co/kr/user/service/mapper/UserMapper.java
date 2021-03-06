package co.kr.user.service.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import co.kr.security.VO.UserVO;

@Mapper
public interface UserMapper {

	public int idCheck(String id);

	public HashMap<String, Object> login(HashMap<String, Object> param);

	public int cnt();

	public int join(UserVO vo);

	public List<HashMap<String, Object>> userCheck();

	public int delete(int user_no);

	public HashMap<String, Object> detail(int user_no);

	public int modify(HashMap<String, Object> param);

	public HashMap<String, Object> IdFind(HashMap<String, Object> param);


}
