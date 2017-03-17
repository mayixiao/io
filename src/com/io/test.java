package com.io;

import java.io.FileInputStream;
import java.io.InputStream;

public class test {

	public static void main(String[] args) throws Exception {
		
		
		//读取文件内容
		FileInputStream fileInputStream = new FileInputStream("F:\\test.txt");
		
		//fileInputStream.read();
		byte[] bbuf = new byte[1024];  
	    int hasRead = 0;  
        //使用循环来重复“取水”的过程  
        while((hasRead = fileInputStream.read(bbuf))>0)  
        {  
            //取出"竹筒"中(字节),将字节数组转成字符串输入  
            System.out.println(new String(bbuf,0,hasRead));  
        }  
        fileInputStream.close();  
        
		
		InputStream inputStream = new FileInputStream("F:\\test.txt");
	}
}
