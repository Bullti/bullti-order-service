package com.nowon.bullti.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

import com.nowon.bullti.security.service.CustomUserDetailsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
@EnableMethodSecurity
@Configuration
public class SecurityConfig {
	
	//@Bean
	//PasswordEncoder passwordEncoder() {
		
	//	return new BCryptPasswordEncoder(14);
		
	//}
	
	@Bean
	UserDetailsService userDetailsService() { return new CustomUserDetailsService();}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
		.csrf(AbstractHttpConfigurer::disable)
		.authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
				.requestMatchers("/","/loginForm","/css/**","/images/**","/js/**","/login","/signup","/**")
				.permitAll()
				.requestMatchers("/store/**").hasRole("STORE")
				.anyRequest().authenticated())
		.formLogin(
				formLogin -> formLogin.loginPage("/login").loginProcessingUrl("/login").usernameParameter("id")
						.passwordParameter("pass")
						.permitAll().defaultSuccessUrl("/")
						.failureUrl("/login")
						.loginProcessingUrl("/login")
				)
		.logout(logout -> logout
				.logoutSuccessUrl("/login")
				.logoutUrl("/logout")
				);
		
		return http.build();
		
	}
	
	
	
}
