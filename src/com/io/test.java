package com.io;

import java.io.FileInputStream;
import java.io.InputStream;

public class test {

	public static void main(String[] args) throws Exception {
		
		
		//��ȡ�ļ�����
		FileInputStream fileInputStream = new FileInputStream("F:\\test.txt");
		
		//fileInputStream.read();
		byte[] bbuf = new byte[1024];  
	    int hasRead = 0;  
        //ʹ��ѭ�����ظ���ȡˮ���Ĺ���  
        while((hasRead = fileInputStream.read(bbuf))>0)  
        {  
            //ȡ��"��Ͳ"��(�ֽ�),���ֽ�����ת���ַ�������  
            System.out.println(new String(bbuf,0,hasRead));  
        }  
        fileInputStream.close();  
        
		
		InputStream inputStream = new FileInputStream("F:\\test.txt");
	}
}
