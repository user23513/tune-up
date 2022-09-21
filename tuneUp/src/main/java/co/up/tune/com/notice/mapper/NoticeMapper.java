package co.up.tune.com.notice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.up.tune.com.vo.CommunityVO;
import co.up.tune.prj.vo.BusinessVO;

public interface NoticeMapper {
	
	List<CommunityVO> noticeList(); //공지사항 전체조회
	CommunityVO noticeSelect(CommunityVO vo); //공지사항 상세조회
	int noticeInsert(CommunityVO vo); //공지사항 입력
	int noticeUpdate(CommunityVO vo); //공지사항 수정
	int noticeDelete(CommunityVO vo); //공지사항 삭제
	List<CommunityVO> noticeSearch(@Param("key") String key, @Param("val") String val); //공지사항 검색
	int noticeHitUpdate(CommunityVO vo); //공지사항 조회수증가
	
	//=========================
	List<BusinessVO> ganttList(BusinessVO vo);

}
