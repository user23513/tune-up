package co.up.tune.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

import co.up.tune.emp.service.UsersService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

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
	public AccessDeniedHandler accessDeniedHandler() {
		return new WebAccessDenyHandler();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> 
							requests
							.antMatchers("/**").permitAll()
							//.antMatchers("/").hasAnyRole("ROLE_ADMIN","ROLE_USER")
							.anyRequest().authenticated())
				.formLogin().loginPage("/login")
							.usernameParameter("id")
							.passwordParameter("pw")
							.successHandler(loginHandler())
							.and()
				.logout().logoutUrl("/logout")
						 .logoutSuccessUrl("/login")
						 .invalidateHttpSession(true)
						 .deleteCookies("JSESSIONID")
						 .and()
				.exceptionHandling()
						 .accessDeniedHandler(accessDeniedHandler())
						 .and()
				/* .csrf().disable() */
				.userDetailsService(usersService());

		return http.build();
	}
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/assets/**", "/fileUpload/**", "/forms/**", "/fullcalendar-5.11.3/**", "/js/**");
	}

}
