package co.up.tune.aprv.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormVO { //결재서식
	int formNo; //서식번호
	String fromNm; //서식이름
	String formCntn; //서식설명
	String formCat; //서식종류
	String empNo; //사번
}
