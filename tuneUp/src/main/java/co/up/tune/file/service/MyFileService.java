package co.up.tune.file.service;

import java.util.List;

import co.up.tune.prj.vo.FilesVO;

public interface MyFileService {
	//내파일함 리스트
		List<FilesVO> myFileSelect(FilesVO vo);
		//내 파일함 추가 삭제
		int myFileInsert(FilesVO vo);
		int myFileDelete(FilesVO vo);
}
