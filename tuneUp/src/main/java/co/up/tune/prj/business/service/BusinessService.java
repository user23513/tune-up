package co.up.tune.prj.business.service;

import java.util.List;

import co.up.tune.com.vo.ReplyVO;
import co.up.tune.prj.vo.BusinessVO;
import co.up.tune.prj.vo.FilesVO;

public interface BusinessService {
	
	List<BusinessVO> businessList(BusinessVO vo);
	int businessInsert(BusinessVO vo, FilesVO fvo); //업무 등록
	int businessUpdate(BusinessVO vo);
	int businessDelete(BusinessVO vo);
	
	List<ReplyVO> bReplyList(ReplyVO vo);
	int bReplyInsert(ReplyVO vo); 
	int bReplyDelete(ReplyVO vo);

}
