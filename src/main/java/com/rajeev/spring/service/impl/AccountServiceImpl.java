package com.rajeev.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rajeev.spring.dao.AccountDao;
import com.rajeev.spring.model.Account;
import com.rajeev.spring.service.AccountService;


@Service
public class AccountServiceImpl implements AccountService{

	 @Autowired
	 private AccountDao accountDao;
	
	 @Transactional
	 public Account getStudent(String username, String password) {
	   return accountDao.getAccount(username, password);
	}



}
