package com.alibaba.partybusiness.controller.customcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.partybusiness.config.redis.RedisService;
import com.alibaba.partybusiness.result.CodeMsg;
import com.alibaba.partybusiness.result.Result;
@Controller
public class LoginController {
	
	@Autowired
	private RedisService redisService;
	//登录界面
	@ResponseBody
	 @RequestMapping("/logins")
	    public Result<String> helloHtml(Model model) {
		 return Result.success("sssss");
	    }
	
	

	
	
	

}
