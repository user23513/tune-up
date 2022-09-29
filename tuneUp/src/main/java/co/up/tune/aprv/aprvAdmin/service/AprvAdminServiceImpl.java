package co.up.tune.aprv.aprvAdmin.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.up.tune.aprv.aprvAdmin.mapper.AprvAdminMapper;
import co.up.tune.aprv.vo.AprvVO;
import co.up.tune.aprv.vo.FormVO;

@Service
public class AprvAdminServiceImpl implements AprvAdminService {

	@Autowired
	AprvAdminMapper map;

	@Override
	public List<AprvVO> aprvListAll(String reqSt) {
		return map.aprvListAll(reqSt);
	}

	@Override
	public AprvVO aprvSelect(AprvVO vo) {
		return map.aprvSelect(vo);
	}

	@Override
	public int aprvAdminDel(AprvVO vo) {
		return map.aprvAdminDel(vo);
	}

	@Override
	public int aprvAdminUp(AprvVO vo) {
		return map.aprvAdminUp(vo);
	}

	@Override
	public List<FormVO> aprvFormAll(String formCat) {
		return map.aprvFormAll(formCat);
	}

	@Override
	public FormVO formSelect(FormVO vo) {
		return map.formSelect(vo);
	}

	@Override
	public int formAdminDel(AprvVO vo) {
		return map.formAdminDel(vo);
	}

	@Override
	public int formAdminUp(AprvVO vo) {
		return map.formAdminUp(vo);
	}
	
	

}
