package com.daiso.main;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daiso.security.Account;
import com.daiso.security.AccountService;
import com.daiso.service.MemberService;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	private MemberService memberService;
	
	@Autowired
	AccountService accountService;
	
	
	//회원가입 페이지
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}
	
	@PostMapping("/register")
	@ResponseBody
	public Map join(Model model, @RequestBody Map<String, String> params) {
		logger.info("success123");
//		logger.info("email"+params.get("m_email"));
		Account account=new Account();
		account.setId(params.get("m_userid"));
		account.setPassword(params.get("m_password"));
		account.setNickname(params.get("m_nickname"));
		account.setEmail(params.get("m_email"));
		accountService.save(account, "ROLE_ADMIN");
		params.clear();
		params.put("code","success");
		params.put("m_userid",account.getId());
		return params;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, HttpServletRequest req) {
		
		model.addAttribute("message", req.getServletContext());
		return "login";
	}

	@GetMapping("/loginSuccess")
	public String loginSuccess(HttpServletRequest req) {
		logger.info("성공" + req.getUserPrincipal().getName());
		logger.info("성공" + req.getSession().getId());
		Authentication auth = (Authentication) req.getUserPrincipal();
		logger.info("성공" + auth.getPrincipal());
		
		return "redirect:/";
	}
	
	
	
}
