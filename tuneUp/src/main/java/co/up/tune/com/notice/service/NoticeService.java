package co.up.tune.com.notice.service;

import java.util.List;

import co.up.tune.com.vo.CommunityVO;

public interface NoticeService {
	
	List<CommunityVO> noticeList(); //공지사항 전체조회
	CommunityVO noticeSelect(CommunityVO vo); //공지사항 상세조회
	int noticeInsert(CommunityVO vo); //공지사항 입력
	int noticeUpdate(CommunityVO vo); //공지사항 수정
	int noticeDelete(CommunityVO vo); //공지사항 삭제
	List<CommunityVO> noticeSearch(String key, String val); //공지사항 검색
	int noticeHitUpdate(CommunityVO vo); //공지사항 조회수증가
	

}
