package com.alibaba.partybusiness.service;

import java.util.Map;
public interface LoginService {

	/**
	 * 用户身份验证
	 * @param username
	 * @param password
	 * @return
	 */
	public String Authentication();
	/**
	 * 1688授权回调成功中转
	 * @param code
	 * @return
	 */
	public Map<String, String> successfulTransfer(String code);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
