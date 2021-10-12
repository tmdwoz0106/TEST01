package co.kr.like.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.like.service.LikeService;
import co.kr.like.service.mapper.LikeMapper;

@Service
public class LikeServiceImpl implements LikeService{

	@Autowired
	public LikeMapper likeMapper;
}
