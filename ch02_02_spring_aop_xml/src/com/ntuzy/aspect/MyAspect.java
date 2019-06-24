package com.ntuzy.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

	public void log() {
		System.out.println("ʹ��Aop������־log....");
	}

	// ǰ��֪ͨ
	public void before() {
		System.out.println("ִ��ǰ��֪ͨ....");
	}

	// ����֪ͨ
	public void after() {
		System.out.println("ִ������֪ͨ...");
	}

	// ����֪ͨ
	public void afterReturning() {
		System.out.println("ִ�к���֪ͨ...");
	}

	// �쳣֪ͨ
	public void afterThrowing() {
		System.out.println("ִ���쳣֪ͨ...");
	}

	// ����֪ͨ
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
