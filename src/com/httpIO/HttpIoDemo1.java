package com.httpIO;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

//大文件下载 单线程
public class HttpIoDemo1 {

	public static void main(String[] args) throws Exception {
		String strUrl= "http://localhost:3636/hello.avi";//将文件放到tomcat/webapp/root下
		URL url = new URL(strUrl);
		HttpURLConnection connection =  (HttpURLConnection)url.openConnection();
		
		InputStream is = connection.getInputStream();
		//读取联接中的数据
		byte[] buffer = new byte[1024];
		int len =-1;
		
		//将数据存储到本地实现 文件下载
		FileOutputStream fos = new FileOutputStream("F:/hello.avi");
		while ((len=is.read(buffer))!=-1) {
			fos.write(buffer);
		}
		fos.close();
	}
}
