package com.HomEase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration

public class HomEaseConfig {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomerUserDetailsService(); 
	}
	
	
	protected SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
		
		httpSecurity.csrf().disable()
		.authorizeRequests()
		.requestMatchers("/home").permitAll()
		.requestMatchers("/admin").hasAuthority("ADMIN")
		.requestMatchers("/user").hasAuthority("USER")
		.requestMatchers("/serviceProvider").hasAuthority("SPROVIDER")
		
		.anyRequest().authenticated()
		
		.and()
		.formLogin()
		
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		
		.and()
		.exceptionHandling()
		.accessDeniedPage("/accessDenied");
		
		return httpSecurity.build();
	}
}
