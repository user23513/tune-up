package co.up.tune.com.notice.service;

import java.util.List;

import com.github.pagehelper.Page;

import co.up.tune.com.vo.CommunityVO;
import co.up.tune.com.vo.SearchVO;
import co.up.tune.prj.vo.BusinessVO;

public interface NoticeService {
	
	Page<CommunityVO> noticeList(int pageNo, SearchVO search); //공지사항 전체조회
	CommunityVO noticeSelect(CommunityVO vo); //공지사항 상세조회
	int noticeInsert(CommunityVO vo); //공지사항 입력
	int noticeUpdate(CommunityVO vo); //공지사항 수정
	int noticeDelete(CommunityVO vo); //공지사항 삭제
	List<CommunityVO> noticeSearch(String key, String val); //공지사항 검색
	int noticeHitUpdate(CommunityVO vo); //공지사항 조회수증가
	
	//======================
	List<BusinessVO> ganttList(BusinessVO vo);
}
