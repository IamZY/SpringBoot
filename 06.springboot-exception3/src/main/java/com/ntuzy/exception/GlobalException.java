package com.ntuzy.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 抽取出异常处理
 * @author iamzy
 *
 */

@ControllerAdvice
public class GlobalException {
	// java.lang.ArithmeticException
	@ExceptionHandler(value = { java.lang.ArithmeticException.class })
	public ModelAndView handlerArithmeticException(Exception e) {
		// 设置错误信息
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception", e.toString());
		modelAndView.setViewName("error1");
		return modelAndView;
	}

	// java.lang.NullPointerException
	@ExceptionHandler(value = { java.lang.NullPointerException.class })
	public ModelAndView handlerNullPointerException(Exception e) {
		// 设置错误信息
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception", e.toString());
		modelAndView.setViewName("error2");
		return modelAndView;
	}
}
