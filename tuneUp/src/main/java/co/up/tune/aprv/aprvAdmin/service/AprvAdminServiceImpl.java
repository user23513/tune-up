package co.up.tune.aprv.aprvAdmin.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.up.tune.aprv.aprvAdmin.mapper.AprvAdminMapper;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.FormVO;
import co.up.tune.aprv.vo.ReferVO;

@Service
public class AprvAdminServiceImpl implements AprvAdminService {

	@Autowired
	AprvAdminMapper ad;

	@Override
	public List<AprvVO> aprvListAll() {
		return ad.aprvListAll();
	}

	@Override
	public AprvVO aprvSelect(AprvVO vo) {
		return ad.aprvSelect(vo);
	}

	@Override
	public int aprvAdminDel(AprvVO vo) {
		return ad.aprvAdminDel(vo);
	}

	@Override
	public int aprvAdminUp(AprvVO vo) {
		return ad.aprvAdminUp(vo);
	}

	@Override  /////참조 수정 반복
	public int aprvAdminReferUp(List<ReferVO> list) {
		int cnt = 0;
		for (ReferVO vo : list) {
			ad.aprvAdminReferUp(vo);
			cnt++;
		};
	
		if(cnt == list.size()) {
			return cnt;
		} else {
			return 0;
		}
		
	}

	@Override
	public List<FormVO> aprvFormAll() {
		return ad.aprvFormAll();
	}

	@Override
	public FormVO formSelect(FormVO vo) {
		return ad.formSelect(vo);
	}

	@Override
	public int formAdminDel(AprvVO vo) {
		return ad.formAdminDel(vo);
	}

	@Override
	public int formAdminUp(AprvVO vo) {
		return ad.formAdminUp(vo);
	}
	
	

}
