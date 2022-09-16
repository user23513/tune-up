package co.up.tune.emp.vo;


import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpVO {
	String empNo; //사번
	String nm;  //이름
	String id;  //아이디
	String pw;  //비밀번호
	String phone;  //휴대폰
	String email;  //이메일
	String pic;  //프로필사진
	String sign;  //결재서명
	String dept;  //부서명
	String position;  //직위
	String addr;  //자택주소
	String comPhone;  //사내전화
	String hDate;  //입사일
	String auth;  //권한
	Date birth;  //생년월일
	String gender;  //성별
	String st;  //상태
	String mng;  //관리자
    Date fDate;  //퇴사일
    String zip; //우편번호
}
