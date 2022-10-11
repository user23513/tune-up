package co.up.tune.file.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.up.tune.prj.vo.FilesVO;

public interface FileMapper {
	//내파일함 리스트
	List<FilesVO> myFileList(String empNo);//내파일함 리스트
	List<FilesVO> prjFileList(String empNo);//프로젝트 파일함
	List<FilesVO> proPostFileList(FilesVO vo);
	
	int fileDelete(FilesVO vo);//파일 삭제
	int myFileInsert(FilesVO vo);//파일 업로드
	
	int proPostFileUpdate(FilesVO vo);
	
	List<FilesVO> fileSearch(@Param("key") String key, @Param("val") String val);
	

}
