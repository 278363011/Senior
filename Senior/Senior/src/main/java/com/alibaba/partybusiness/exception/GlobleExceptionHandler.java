package com.alibaba.partybusiness.exception;

import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.partybusiness.result.Result;


//全局异常捕获器---根据e来判断
@ControllerAdvice
@ResponseBody
public class GlobleExceptionHandler {
	@ExceptionHandler(value=Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest request,Exception ex) {
    	if(ex instanceof GlobalBusinessException) {
    	return new Result<String>(((GlobalBusinessException) ex).getCodeMsg());
    	}else if (ex instanceof BindException) {
			
		}
		
		return null;
    }
}
