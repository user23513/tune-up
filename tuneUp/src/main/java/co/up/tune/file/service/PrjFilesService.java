package co.up.tune.file.service;

import java.util.List;

import co.up.tune.prj.vo.FilesVO;

public interface PrjFilesService {
	List<FilesVO> prjFileList(String empNo);

}
