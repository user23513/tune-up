package co.up.tune.aprv.vo;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrustVO { //위임
	String empNo; //위임자
	String rptt; //수임자
	Date sdt; //시작일
	Date edt; //종료일
	int trustNo; //위임번호
	String rpttNm;//수임자이름
	String nm;//위임자이름
}
