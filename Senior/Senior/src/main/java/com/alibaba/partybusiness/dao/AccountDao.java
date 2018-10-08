package com.alibaba.partybusiness.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.alibaba.partybusiness.model.Account;

@Mapper
public interface AccountDao {
	public List<Account> getAllUserList();
	public Account getOneUser(@Param("username") String username);
}
