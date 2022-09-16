package co.up.tune.aprv.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AprvLineVO { //기본결재라인
	int lineNo; //라인번호
	int aprvSeq; //결재순서
	String septNm; //부서명
	String aprvr; //결재자
}
