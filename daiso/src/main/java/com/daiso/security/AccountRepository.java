package com.daiso.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mapper.mapper.AccountMapper;

@Repository
public class AccountRepository {
	
	@Autowired
	AccountMapper accountMapper;
	
	
	public Account save(Account account,String role){
		accountMapper.insertUser(account);
		accountMapper.insertUserAutority(account.getId(), role);
		return account;
	}

	public Account findById(String username) {
		// TODO Auto-generated method stub
		return accountMapper.readAccount(username);
	}
	
	public List<String> findAuthoritiesByID(String username)
	{
		return accountMapper.readAutorities(username);
	}
	
}