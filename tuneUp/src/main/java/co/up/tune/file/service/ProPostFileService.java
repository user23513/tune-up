package co.up.tune.file.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import co.up.tune.prj.vo.FilesVO;

public interface ProPostFileService {
	List<FilesVO> proPostFileList(FilesVO vo);
	int proPostFileInsert(FilesVO vo);
	int proPostFileDelete(FilesVO vo);
	FilesVO fileUpload(FilesVO vo, MultipartFile file) throws IllegalStateException, IOException;
}