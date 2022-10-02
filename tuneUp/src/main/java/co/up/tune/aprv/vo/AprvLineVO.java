package co.up.tune.aprv.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AprvLineVO { //결재라인
	int lineNo; //라인번호
	String dept; //부서명
	String empNo; //작성자
	String ap1; // 결재1
	String ap2;// 결재2
	String ap3;//결재3
	String nm1;//이름1
	String nm2;//이름2
	String nm3;//이름3
}
