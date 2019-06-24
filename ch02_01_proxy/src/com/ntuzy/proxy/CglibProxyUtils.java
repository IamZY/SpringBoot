package com.ntuzy.proxy;

import java.lang.reflect.Method;

import com.ntuzy.service.impl.CustomerServiceImpl2;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxyUtils {

	public static Object getProxy(final Object target) {
		return Enhancer.create(CustomerServiceImpl2.class, new MethodInterceptor() {

			@Override
			public Object intercept(Object arg0, Method method, Object[] arg2, MethodProxy arg3) throws Throwable {
				System.out.println("====================");
				Object invoke = method.invoke(target, arg2);
				return invoke;
			}
		});
	}

}
