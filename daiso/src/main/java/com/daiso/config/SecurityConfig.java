package com.daiso.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

import com.daiso.security.AccountService;
import com.daiso.security.CustomAuthenticationProvider;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final String JSESSIONID = null;

	@Autowired
	AccountService accountService;
	
	private CustomAuthenticationProvider customAuthenticationProvider;
	
	@Override
	 public void configure(WebSecurity webSecurity) throws Exception {
	  webSecurity.ignoring().antMatchers("/resources/**", "/css/**", "/fonts/**", "/js/**", "/vendor/**", "/images/**"); 
	 }
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http
        .authorizeRequests()
        	.antMatchers("/register").permitAll()
        	.antMatchers("/detail","/board").hasRole("ADMIN")
        	.antMatchers("/create").permitAll()
        	.antMatchers("/error").permitAll()
        	.antMatchers("/").permitAll()
            .antMatchers("/admin").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and()
//            .formLogin().defaultSuccessUrl("/loginSuccess").and()
       .formLogin()
       		.loginPage("/login")
       		.defaultSuccessUrl("/loginSuccess")
            .permitAll()
            .and()
        .logout()
        .logoutUrl("/logout")
        .logoutSuccessUrl("/") 
        .invalidateHttpSession(true)
        .permitAll();
		
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
	
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(accountService)
			.passwordEncoder(passwordEncoder());
			
	}
	
	@Bean
    public SpringSecurityDialect springSecurityDialect(){
        return new SpringSecurityDialect();
    }
	
}
