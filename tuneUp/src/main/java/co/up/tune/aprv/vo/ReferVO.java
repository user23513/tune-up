package co.up.tune.aprv.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReferVO { //결재참조인
	
	int referNo; //참조번호
	int aprvNo; //결재번호
	String checked; //확인여부
	String empNo; //참조인
	int referAprv; //참조문서번호


}