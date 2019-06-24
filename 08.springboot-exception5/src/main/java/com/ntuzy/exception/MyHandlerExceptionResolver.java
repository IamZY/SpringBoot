package com.ntuzy.exception;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;

@Configuration
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception e) {
		ModelAndView mv = new ModelAndView();
		// 判断不同异常类型，做不同处理
		if (e instanceof ArithmeticException) {
			mv.setViewName("error1");
		}

		if (e instanceof NullPointerException) {
			mv.setViewName("error2");
		}

		mv.addObject("exception", e.toString());
		return mv;
	}

}
