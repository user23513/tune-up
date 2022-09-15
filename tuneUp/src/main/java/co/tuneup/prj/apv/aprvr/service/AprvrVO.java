package co.tuneup.prj.apv.aprvr.service;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AprvrVO { //결재자
	int aprvNo; //결재번호
	Date appvDttm; //결재일시
	String recaResn; //반려사유
	int aprvSeq; //결재순서
	String aprvSt; //결재상태
}