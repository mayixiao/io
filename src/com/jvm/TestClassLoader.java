package com.jvm;

public class TestClassLoader {

	public static void main(String[] args) throws ClassNotFoundException {
		
		//加载方式1
		Class.forName("com.jvm.Person");//类全路径
		Class.forName("com.jvm.Person", false, ClassLoader.getSystemClassLoader());//false 加载时不初始化
		
		//自动加载
		Person p = new Person();
		p.setName("ss");
	}
}
