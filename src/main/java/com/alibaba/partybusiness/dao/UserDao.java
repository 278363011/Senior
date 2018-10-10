package com.alibaba.partybusiness.dao;

import com.alibaba.partybusiness.model.User;

public interface UserDao {
	 public User findByUserName(String username);
}
