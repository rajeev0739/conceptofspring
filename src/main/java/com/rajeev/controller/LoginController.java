package com.rajeev.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rajeev.spring.model.Account;
import com.rajeev.spring.service.AccountService;

@Controller


public class LoginController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String login(ModelMap modelMap) {
	
			modelMap.put("acc",new Account());
			return "login";
	}
		
	@RequestMapping(value="/logout.do",method = RequestMethod.GET)
	public String logout(HttpSession session) {
		
		session.removeAttribute("username");
		return "redirect:login.html";
	}
	
	
	@RequestMapping(value="/logins.do",method = RequestMethod.POST)
	public String login(@ModelAttribute(value="acc") Account acc,ModelMap modelMap,HttpSession session) {
		
		if(accountService.getStudent(acc.getUsername(), acc.getPassword())!=null) {
			session.setAttribute("username", acc.getUsername());
			return "welcome";
		}else {
			modelMap.put("message","account invalid");
			return "login";
		}
		
	}
	

	

}
