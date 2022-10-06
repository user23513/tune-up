package co.up.tune.aprv.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 전자결재 서식 VO
 * @author 윤정은
 * @date 2022.09.24
 * @version 1.0
 **/

@Getter
@Setter
public class FormVO {

	int formNo; // 서식번호
	String ttl; // 서식이름
	String cntn; // 서식설명
	String formCat; // 서식종류
	String empNo; // 사번
	String formAuth; // 공개여부
	String nm;// 작성자이름
}
