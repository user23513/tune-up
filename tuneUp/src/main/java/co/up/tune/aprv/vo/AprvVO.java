package co.up.tune.aprv.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

/**
 * 전자결재 VO
 * @author 윤정은
 * @date 2022.09.24
 * @version 1.1
 **/

@Getter
@Setter
public class AprvVO { //전자결재
	int aprvNo; //결재번호
	String empNo; //사번
	String ttl; //제목
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	Date dttm; //작성일시
	String cntn; //결재내용
	String fNm;	//파일이름
	String fPath; //파일위치
	String reqSt; //신청상태
	String aprvEtc; //상신의견
	String deadline; //마감일
	String impts; //중요
	String nm; //이름
	
	//테이블에 없는 필드
	String aprvSt; //승인상태
	String refer; //참조인목록
	String referNm; //참조인이름목록
	String deadDay; //마감일자
	String deadTime; //마감일시
	int lineNo; //결재선번호
}
