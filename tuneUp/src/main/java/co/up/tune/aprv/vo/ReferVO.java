package co.up.tune.aprv.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 전자결재 참조인 VO
 * @author 윤정은
 * @date 2022.09.24
 * @version 1.2
 **/


@Getter
@Setter
public class ReferVO { 
	
	int referNo; //참조번호
	int aprvNo; //결재번호
	String empNo; //참조인
	String nm;//참조인이름
	
	

}
