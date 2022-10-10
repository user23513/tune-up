package co.up.tune.aprv.vo;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 전자결재 승인 VO
 * @author 윤정은
 * @date 2022.09.24
 * @version 1.2
 **/

@Getter
@Setter
public class ApprovalVO { 
	
	String aprvr;//결재자사번
	int aprvNo; //결재번호
	String aprvDttm; //결재일시
	int aprvSeq; //결재순서
	String aprvSt;//승인상태
	String reject; //반려사유
	String nm;//결재자이름
	
	////테이블에 없는 필드
	List<Integer> valueArr; //체크박스 번호
	String sign; //file path
	
}