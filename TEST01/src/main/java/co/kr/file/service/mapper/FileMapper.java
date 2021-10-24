package co.kr.file.service.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

@Mapper
public interface FileMapper {

	public int insert(HashMap<String, Object> param);

	public int uploadMax();

	public List<MultipartFile> fileList(int board_no);

	public int delete(int board_no);

}
