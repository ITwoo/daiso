package com.daiso.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daiso.security.Account;
import com.daiso.security.AccountService;
import com.mapper.mapper.AccountMapper;

@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;

	@Autowired
	AccountMapper accountMapper;
	
	
	//ADMIN 계정 부여
	@GetMapping("/create")
	public Account create(){
		Account account=new Account();
		account.setId("admin5");
		account.setPassword("1234");
		accountService.save(account, "ROLE_ADMIN");
		return account;
	}
	
	//서비스 권한 부여
	@GetMapping("/get")
	public Account test(Model m) {
		Account a = new Account();
		a.setId( (String)m.getAttribute("username"));
		a.setPassword((String)m.getAttribute("password"));
		return a;
	}
	
}