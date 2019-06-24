package com.ntuzy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxyUtils {

	/**
	 * 使用jdk动态代理获取代理对象
	 * 
	 * @return
	 */
	public static Object getProxy(final Object target) {
		// 基于接口的代理
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
				new InvocationHandler() {

					// 每次调用代理类对象的时候执行
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("==========");
						
						// 调用目标对象的方法
						Object invoke = method.invoke(target, args);
						return invoke;
					}
				});

	}

}
