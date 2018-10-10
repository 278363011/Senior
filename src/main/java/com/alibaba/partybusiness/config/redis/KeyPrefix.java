package com.alibaba.partybusiness.config.redis;

public interface KeyPrefix {

	public int expireSeconds();
	public String getprefix();
}
