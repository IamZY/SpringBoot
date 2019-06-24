package com.ntuzy.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

	public void log() {
		System.out.println("使用Aop切入日志log....");
	}

	// 前置通知
	public void before() {
		System.out.println("执行前置通知....");
	}

	// 最终通知
	public void after() {
		System.out.println("执行最终通知...");
	}

	// 后置通知
	public void afterReturning() {
		System.out.println("执行后置通知...");
	}

	// 异常通知
	public void afterThrowing() {
		System.out.println("执行异常通知...");
	}

	// 环绕通知
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
