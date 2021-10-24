package co.kr.file.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import co.kr.file.service.FileService;
import co.kr.file.service.mapper.FileMapper;

@Service
public class FileServiceImpl implements FileService{

	@Autowired
	public FileMapper fileMapper;

	@Override
	public int insert(HashMap<String, Object> param) {
		return fileMapper.insert(param);
	}

	@Override
	public int uploadMax() {
		return fileMapper.uploadMax();
	}

	@Override
	public List<MultipartFile> FileList(int board_no) {
		return fileMapper.fileList(board_no);
	}

	@Override
	public int delete(int board_no) {
		return fileMapper.delete(board_no);
	}
}
