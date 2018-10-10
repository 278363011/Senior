package com.alibaba.partybusiness.config.redis;

public abstract class BasePrefix implements KeyPrefix{

	
	private int expireSeconds;
	private String prefix;
	
	public BasePrefix(String prefix) {
		this(0, prefix);
	}
	
	public BasePrefix(int expireSeconds,String prefix) {
		this.expireSeconds=expireSeconds;
		this.prefix=prefix;
	}
	
	//默认0代表永不过期
	@Override
	public int expireSeconds() {
		return expireSeconds;
	}

	@Override
	public String getprefix() {
		String classname=getClass().getSimpleName();
		return classname+":"+prefix;
	}

}
