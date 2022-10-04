package co.up.tune.prj.vo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilesVO {
	 int fileNo;	//파일번호
	 String fNm;	//파일이름
	 String fPath;	//파일위치
	 String fType;	//파일타입
	 int atchNo;	//첨부파일번호
	 String fCat;  //파일 카테고리
	 String pNm; //프로젝트이름
	 String empNo; //사번
}
