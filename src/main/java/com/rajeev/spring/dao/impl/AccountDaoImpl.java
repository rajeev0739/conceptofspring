package com.rajeev.spring.dao.impl;


import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rajeev.spring.dao.AccountDao;
import com.rajeev.spring.model.Account;


@Repository
public class AccountDaoImpl implements AccountDao{
	
	 private final Logger logger = LoggerFactory.getLogger(AccountDaoImpl.class);
	 private final String getAccountBasedOnUserNameAndPasswordHql="FROM Account acc WHERE acc.username=:user_name AND acc.password=:pass_word";

	@Autowired
	private SessionFactory session;
	
	
	@Override
	public Account getAccount(String un, String pwd) {
		logger.debug(" Received from UI UserName :: "+un+" Password :: "+pwd);
		try {
			Query<Account> query= session.getCurrentSession().createQuery(getAccountBasedOnUserNameAndPasswordHql,Account.class);
	    	query.setParameter("user_name", un);
	    	query.setParameter("pass_word", pwd);
	    	Account account=  	(Account)query.uniqueResult();
	    	if(null!=account) {
    		  logger.debug(" Received from DB UserName :: "+account.getUsername()+" Password :: "+account.getPassword());
	    	}else {
	    		logger.debug(" Received null rom DB ");
	    	}
    	return account;
	}catch (Exception e) {
		logger.error("Exception occured ::"+e);
		return null;
	}


}
	
}
