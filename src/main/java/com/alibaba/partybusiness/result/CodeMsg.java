package com.alibaba.partybusiness.result;

public class CodeMsg {
	private  int code;
	private String msg;
	//调用成功
	public static CodeMsg SUCCESS=new CodeMsg(0,"success");
	//系统错误
	public static CodeMsg SERVER_ERROR=new CodeMsg(50010,"服务端异常!");
	
	
	
	
	
	
	
	
	
	
	
	private CodeMsg(int code, String msg) {
		this.code=code;
		this.msg=msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
