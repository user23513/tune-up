package co.tuneup.prj.apv.formItem.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormItemVO { //서식항목
	int itemNo; //항목번호
	int formNo; //서식번호
	String itemNm; //항목이름
	String itemtyp; //항목타입
	String itemOpt; //항목옵션
	String itemNull; //필수여부
}
