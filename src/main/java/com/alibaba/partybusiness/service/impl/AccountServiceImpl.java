package com.alibaba.partybusiness.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.partybusiness.dao.AccountDao;
import com.alibaba.partybusiness.model.Account;
import com.alibaba.partybusiness.service.AccountService;
import com.github.pagehelper.PageHelper;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountDao accountdao;

	@Override
	public List<Account> getAllUserList(String pagenow,String pagesize) {
		PageHelper.startPage(Integer.parseInt(pagenow), Integer.parseInt(pagesize));
		List<Account> accountlistAccounts=accountdao.getAllUserList();
		//分页封装类
		//PageBean<Account> pageBean=new PageBean<>(Integer.parseInt(pagenow), Integer.parseInt(pagesize), 20);
		return accountlistAccounts;
	}

	@Override
	public Account getOneUser(String username) {
		return accountdao.getOneUser(username);
		
	}
	

}
