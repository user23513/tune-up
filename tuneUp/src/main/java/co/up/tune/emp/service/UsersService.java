package co.up.tune.emp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import co.up.tune.emp.mapper.EmpMapper;
import co.up.tune.emp.vo.CustomUser;
import co.up.tune.emp.vo.EmpVO;

public class UsersService implements UserDetailsService {
	
	@Autowired EmpMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		EmpVO vo =  new EmpVO();
		vo.setId(username);
		vo = mapper.empSelect(vo);
		if(vo == null) {
			throw new UsernameNotFoundException("no user");
		}
		return new CustomUser(vo);
	}
}
