package com.prop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {

	public static void main(String[] args) throws Exception {
		Properties properties = new Properties();
		//读取配置文件
		properties.load(new FileInputStream("F:/MyFile/info.properties"));
		//读配置文件属性
		String count = properties.getProperty("thread.count");
		System.out.println(count);
		
		
		//向配置文件中写
		properties.setProperty("thread0.start", "0");
		properties.setProperty("thread0.end", "2000");
		properties.store(new FileOutputStream("F:/MyFile/info.properties"), "this is commont !!!");
		System.out.println("over");
	
	}
}
