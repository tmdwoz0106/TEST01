package co.kr.file.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	public int insert(HashMap<String, Object> param);

	public int uploadMax();

	public List<MultipartFile> FileList(int board_no);

	public int delete(int board_no);

}
