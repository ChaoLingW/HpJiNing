package com.hpe.service;

import java.sql.SQLException;

import com.hpe.dao.IAccountDao;
import com.hpe.dao.impl.AccountImpl;
import com.hpe.util.JdbcUtil;

public class AccountService {
	
	//在Service层完成事物的处理
	//转账的业务
	//转出账户 转出账户 钱
	
	private IAccountDao accountDao = new AccountImpl();
	
	public boolean transfer(int out, int in, int money){
		
		try {
			//获取调用beginTransaction-->开启事务
			JdbcUtil.beginTranscation();
			
			//调用AccountDao中的updateAccount-->给out账户减maney
			accountDao.updataAccount(out, money);
			//调用AccountDao中的updateAccount-->给in账户加maney
			accountDao.updataAccount(in, -money);
		
			JdbcUtil.commitTransaction();
			return true;
		} catch (Exception e) {
			try {
				JdbcUtil.rollbackTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return false;
	}

}
