package co.kr.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.kr.file.service.FileService;

@Controller
public class FileController {

	@Autowired
	public FileService fileService;
}
