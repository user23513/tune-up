package co.up.tune.security;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import co.up.tune.emp.service.UsersService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private Object password;

	@Bean
	public UsersService usersService() {
		return new UsersService();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public CustomLoginSuccessHandler loginHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	@Bean
	public CustomLogoutSuccessHandler logoutHandler() {
		return new CustomLogoutSuccessHandler();
	}

	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new WebAccessDenyHandler();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> 
							requests
							.antMatchers("/**").permitAll()
//							.antMatchers("/login").permitAll()
//							.antMatchers("/**").hasAnyAuthority("ROLE_ADMIN","ROLE_USER")
							.anyRequest().authenticated())
				.formLogin().loginPage("/login")
							.usernameParameter("id")
							.passwordParameter("pw")
							.successHandler(loginHandler())
							.and()
				.logout().logoutUrl("/logout")
						 //.logoutSuccessUrl("/login")
						 .invalidateHttpSession(true)
						 .deleteCookies("JSESSIONID")
						 .logoutSuccessHandler(logoutHandler())
						 .and()
				.exceptionHandling()
						 .accessDeniedHandler(accessDeniedHandler())
						 .and()
				 //.csrf().disable()
				.userDetailsService(usersService());

		return http.build();
	}
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/assets/**", "/fileUpload/**", "/forms/**", "/fullcalendar-5.11.3/**", "/js/**");
	}


}
