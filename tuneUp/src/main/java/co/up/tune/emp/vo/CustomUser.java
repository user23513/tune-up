package co.up.tune.emp.vo;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class CustomUser extends User {
	private EmpVO member;	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}	
	public CustomUser(EmpVO vo) {
		super(vo.getId(), 
				vo.getPw(), 
				Collections.singletonList(new SimpleGrantedAuthority(vo.getAuth())));
	}
}
