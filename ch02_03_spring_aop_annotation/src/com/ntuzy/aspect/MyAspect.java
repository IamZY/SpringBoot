package com.ntuzy.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 注解版本的切面类
 * 
 * @author iamzy
 *
 */
@Aspect
public class MyAspect {

	// @Before(value = "execution(public *
	// com.ntuzy.service.impl.CustomerServiceImpl.*(..))")
	public void log() {
		System.out.println("使用注解切入日志log....");
	}

	// 前置通知
	@Before(value = "execution(public * com.ntuzy.service.impl.CustomerServiceImpl.*(..))")
	public void before() {
		System.out.println("执行前置通知....");
	}

	// 最终通知
	@After(value = "execution(public * com.ntuzy.service.impl.CustomerServiceImpl.*(..))")
	public void after() {
		System.out.println("执行最终通知...");
	}

	// 后置通知
	@AfterReturning(value = "execution(public * com.ntuzy.service.impl.CustomerServiceImpl.*(..))")
	public void afterReturning() {
		System.out.println("执行后置通知...");
	}

	// 异常通知
	@AfterThrowing(value = "execution(public * com.ntuzy.service.impl.CustomerServiceImpl.*(..))")
	public void afterThrowing() {
		System.out.println("执行异常通知...");
	}

	// 环绕通知
	@Around(value = "execution(public * com.ntuzy.service.impl.CustomerServiceImpl.*(..))")
	public void around(ProceedingJoinPoint jp) {
		System.out.println("前面执行的代码....");
		// 执行目标的方法
		try {
			jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("后面执行的代码....");
	}

}
