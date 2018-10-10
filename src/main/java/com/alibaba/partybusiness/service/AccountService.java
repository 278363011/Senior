package com.alibaba.partybusiness.service;

import java.util.List;

import com.alibaba.partybusiness.model.Account;

public interface AccountService {
	/**
	 * 获取所有的用户列表集合
	 * @return
	 */
	public List<Account> getAllUserList(String pagenow,String pagesize);
	
	/**
	 * 获取单个用户
	 * @param username
	 * @return
	 */
	public Account getOneUser(String username);
}
