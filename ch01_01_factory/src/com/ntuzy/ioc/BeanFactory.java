package com.ntuzy.ioc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 创建对象工厂 模拟ioc容器
 * 
 * @author iamzy
 *
 */
public class BeanFactory {

	/**
	 * 初始化properties
	 */
	private static Properties props = new Properties();

	static {
		InputStream inputStream = BeanFactory.class.getResourceAsStream("/beans.properties");

		try {
			props.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获取对象
	 * 
	 * @return
	 */
	public static Object getBean(String name) {

		// 根据名字创建不同对象
		String className = props.getProperty(name);
		// 反射
		try {
			return Class.forName(className).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
