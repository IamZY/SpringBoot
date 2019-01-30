package com.ntuzy.demo.intecpter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterecepter implements HandlerInterceptor{

	/**
	 * 所有的完成之前
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("LoginIntercepter afterCompletion");
		
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	/**
	 * 调用完Controller之后 渲染视图之前
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("LoginIntercepter postHandle");
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * 进入Controller之前
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("LoginIntercepter preHandle");
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	
	
}
