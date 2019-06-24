package com.ntuzy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxyUtils {

	/**
	 * ʹ��jdk��̬�����ȡ�������
	 * 
	 * @return
	 */
	public static Object getProxy(final Object target) {
		// ���ڽӿڵĴ���
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
				new InvocationHandler() {

					// ÿ�ε��ô���������ʱ��ִ��
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("==========");
						
						// ����Ŀ�����ķ���
						Object invoke = method.invoke(target, args);
						return invoke;
					}
				});

	}

}
