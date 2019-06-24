package com.ntuzy.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * ע��汾��������
 * 
 * @author iamzy
 *
 */
@Aspect
public class MyAspect {

	// @Before(value = "execution(public *
	// com.ntuzy.service.impl.CustomerServiceImpl.*(..))")
	public void log() {
		System.out.println("ʹ��ע��������־log....");
	}

	// ǰ��֪ͨ
	@Before(value = "execution(public * com.ntuzy.service.impl.CustomerServiceImpl.*(..))")
	public void before() {
		System.out.println("ִ��ǰ��֪ͨ....");
	}

	// ����֪ͨ
	@After(value = "execution(public * com.ntuzy.service.impl.CustomerServiceImpl.*(..))")
	public void after() {
		System.out.println("ִ������֪ͨ...");
	}

	// ����֪ͨ
	@AfterReturning(value = "execution(public * com.ntuzy.service.impl.CustomerServiceImpl.*(..))")
	public void afterReturning() {
		System.out.println("ִ�к���֪ͨ...");
	}

	// �쳣֪ͨ
	@AfterThrowing(value = "execution(public * com.ntuzy.service.impl.CustomerServiceImpl.*(..))")
	public void afterThrowing() {
		System.out.println("ִ���쳣֪ͨ...");
	}

	// ����֪ͨ
	@Around(value = "execution(public * com.ntuzy.service.impl.CustomerServiceImpl.*(..))")
	public void around(ProceedingJoinPoint jp) {
		System.out.println("ǰ��ִ�еĴ���....");
		// ִ��Ŀ��ķ���
		try {
			jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("����ִ�еĴ���....");
	}

}
