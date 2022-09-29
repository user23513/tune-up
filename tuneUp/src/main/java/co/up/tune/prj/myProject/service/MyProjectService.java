package co.up.tune.prj.myProject.service;

import java.util.List;

import co.up.tune.prj.vo.ProjectVO;

public interface MyProjectService {

	List<ProjectVO> myPrjList(int empNo); //내프로젝트 리스트
}
