package com.ntuzy.ioc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * �������󹤳� ģ��ioc����
 * 
 * @author iamzy
 *
 */
public class BeanFactory {

	/**
	 * ��ʼ��properties
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
	 * ��ȡ����
	 * 
	 * @return
	 */
	public static Object getBean(String name) {

		// �������ִ�����ͬ����
		String className = props.getProperty(name);
		// ����
		try {
			return Class.forName(className).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
