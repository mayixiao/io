package com.jvm;

public class TestClassLoader {

	public static void main(String[] args) throws ClassNotFoundException {
		
		//���ط�ʽ1
		Class.forName("com.jvm.Person");//��ȫ·��
		Class.forName("com.jvm.Person", false, ClassLoader.getSystemClassLoader());//false ����ʱ����ʼ��
		
		//�Զ�����
		Person p = new Person();
		p.setName("ss");
	}
}
