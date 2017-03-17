package com.prop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {

	public static void main(String[] args) throws Exception {
		Properties properties = new Properties();
		//��ȡ�����ļ�
		properties.load(new FileInputStream("F:/MyFile/info.properties"));
		//�������ļ�����
		String count = properties.getProperty("thread.count");
		System.out.println(count);
		
		
		//�������ļ���д
		properties.setProperty("thread0.start", "0");
		properties.setProperty("thread0.end", "2000");
		properties.store(new FileOutputStream("F:/MyFile/info.properties"), "this is commont !!!");
		System.out.println("over");
	
	}
}
