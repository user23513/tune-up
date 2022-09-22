package co.up.tune.emp.vo;

import java.sql.Timestamp;

import lombok.Data;
@Data
public class AnnlvVO {
	int annlvNo; 	//연차번호
	Timestamp annlvUsed; 	//연차사용일
	String empNo; 	//사번
}
