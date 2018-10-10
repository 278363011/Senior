package com.alibaba.partybusiness.exception;
import com.alibaba.partybusiness.result.CodeMsg;

public class GlobalBusinessException extends RuntimeException{
  private static final long serialVersionUID = 7432114585618814520L;
  private CodeMsg codeMsg;
  public GlobalBusinessException(CodeMsg cm) {
	  super(cm.toString());
	  this.codeMsg=cm;
  }
public CodeMsg getCodeMsg() {
	return codeMsg;
}
public void setCodeMsg(CodeMsg codeMsg) {
	this.codeMsg = codeMsg;
}

	
}
