package co.up.tune.file.service;

import java.util.List;

import co.up.tune.prj.vo.FilesVO;

public interface MyFilesService {
	
	List<FilesVO> myFileList(String empNo); //내파일함 리스트
	int myFileInsert(FilesVO vo);//파일 업로드
	List<FilesVO> fileSearch(String key, String val);
}
