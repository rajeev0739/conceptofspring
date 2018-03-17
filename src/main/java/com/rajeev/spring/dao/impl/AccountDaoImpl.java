package com.rajeev.spring.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rajeev.spring.dao.AccountDao;
import com.rajeev.spring.model.Account;

@Repository
public class AccountDaoImpl implements AccountDao{
	private static final Logger logger = Logger.getLogger(AccountDaoImpl.class);
	@Autowired
	private SessionFactory session;
	
	
	@Override
	public Account getAccount(String u, String p) {
		logger.debug(" Received from UI UserName :: "+u+"Password :: "+p);
		try {
			Query query= session.getCurrentSession().createQuery("from Account acc where acc.username=:u and acc.password=:p");
	    	query.setParameter("u", u);
	    	query.setParameter("p", p);
	    	Account account=  	(Account)query.uniqueResult();
	    	if(null!=account) {
    		  logger.debug(" Received from DB UserName :: "+account.getUsername()+"Password :: "+account.getPassword());
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
