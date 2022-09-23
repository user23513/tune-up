package co.up.tune.aprv.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AprvLineVO { //결재라인
	int lineNo; //라인번호
	String aprvr; //결재자
	int aprvSeq; //결재순서
	String dept; //부서명
	String defYn; //기본설정여부
	String empNo; //소유자
}
