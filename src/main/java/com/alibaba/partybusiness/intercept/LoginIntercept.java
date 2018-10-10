//package com.alibaba.partybusiness.intercept;
//
//import java.util.Date;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//
//public class LoginIntercept implements HandlerInterceptor {
//
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//			throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("退出时间:"+new Date());
//		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//	}
//
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		// TODO Auto-generated method stub
//		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//	}
//
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("访问时间："+new Date());
//		return true;
//	}
//	
//	
//}
