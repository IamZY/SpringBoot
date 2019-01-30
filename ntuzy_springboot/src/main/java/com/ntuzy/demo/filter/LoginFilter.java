package com.ntuzy.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns="/v1/*",filterName="LoginFilter")
public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		String username = request.getParameter("username");
		if ("admin".equals(username)) {
			chain.doFilter(req, res);
		} else {
			return;
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
//		Filter.super.destroy();
		System.out.println("destory LoginFilter...");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
//		Filter.super.init(filterConfig);
		System.out.println("init LoginFilter...");
	}
	
	
	
	

}
