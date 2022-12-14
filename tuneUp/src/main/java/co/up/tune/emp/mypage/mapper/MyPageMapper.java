package co.up.tune.emp.mypage.mapper;

import co.up.tune.emp.vo.EmpVO;
import co.up.tune.prj.vo.PostVO;

public interface MyPageMapper {
	EmpVO empSelectOne(EmpVO vo);
	int profileUpdate(EmpVO vo); //프로필 업데이트
	int picUpdate(EmpVO vo); //프로필 사진 업데이트
	int signUpdate(EmpVO vo); //결재 서명 업데이트

	PostVO postLook(PostVO vo);
}
