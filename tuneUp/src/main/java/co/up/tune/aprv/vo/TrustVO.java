package co.up.tune.aprv.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrustVO { //위임
	String aprvr; //결재자
	String rptt; //수임자
	Date sdt; //시작일
	Date edt; //종료일
}
