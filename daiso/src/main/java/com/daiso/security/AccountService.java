package com.daiso.security;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class AccountService implements UserDetailsService{
	
	
	@Autowired
	AccountRepository accounts;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	 private static final Logger logger = LoggerFactory.getLogger(AccountService.class);
//	 private static final Logger logger2 = LoggerFactory.getLogger(AccountService.class);
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Account user = accounts.findById(username);
		user.setAuthorities(getAuthorities(username));
		String password = user.getPassword();
//		password = password.substring(7);
//		password = password.substring(9);
		logger.info("log = " + password);
		logger.info("log = " + user.toString());
		user.setPassword(password);
		UserDetails userDetails = null;
		userDetails = user;
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        
//        org.springframework.security.core.userdetails.User.UserBuilder builder =
//            org.springframework.security.core.userdetails.User.builder()
//            .passwordEncoder(encoder::encode);
// 
//        if (user != null) {
//            userDetails = builder.username(user.getUsername())
//                    .password(user.getPassword())
//                    .authorities(user.getAuthorities())
//                    .build();
//        }
        logger.info("log = " + userDetails.getPassword());
        return userDetails;


	}
	public Account save(Account account,String role) {
		// TODO Auto-generated method stub

		account.setPassword(passwordEncoder.encode(account.getPassword()));
//		account.setPassword(account.getPassword());
		account.setAccountNonExpired(true);
		account.setAccountNonLocked(true);
		account.setCredentialsNonExpired(true);
		account.setEnabled(true);
		return accounts.save(account, role);
	}
	
	public Collection<GrantedAuthority> getAuthorities(String username) 
	{ 
		List<String> string_authorities = accounts.findAuthoritiesByID(username);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(); 
		for (String authority : string_authorities) 
		{ 
			authorities.add(new SimpleGrantedAuthority(authority)); 
		} 
		return authorities; 
	}

}