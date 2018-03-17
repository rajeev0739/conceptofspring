package com.rajeev.spring.dao;

import com.rajeev.spring.model.Account;

public interface AccountDao {

	public Account getAccount(String username,String password);
}
