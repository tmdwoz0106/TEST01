package co.kr.like.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.like.service.LikeService;
import co.kr.like.service.mapper.LikeMapper;

@Service
public class LikeServiceImpl implements LikeService{

	@Autowired
	public LikeMapper likeMapper;


	@Override
	public int likeCnt(int board_no) {
		return likeMapper.likeCnt(board_no);
	}

	@Override
	public int likeMax() {
		return likeMapper.likeMax();
	}

	@Override
	public int insert(HashMap<String, Object> param) {
		
		return likeMapper.insert(param);
	}

	@Override
	public int likeBtn(HashMap<String, Object> param) {
		
		return likeMapper.likeBtn(param);
	}

	@Override
	public int delete(int board_no,int user_no) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("board_no", board_no);
		param.put("user_no", user_no);
		return likeMapper.delete(param);
	}

	
}
