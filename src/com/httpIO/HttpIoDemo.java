package com.httpIO;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
//文件下载
public class HttpIoDemo {

	public static void main(String[] args) throws Exception {
//		String strUrl= "http://localhost:3636/hello.txt";
		String strUrl= "https://www.baidu.com/";
		URL url = new URL(strUrl);
		HttpURLConnection connection =  (HttpURLConnection)url.openConnection();
		int len = connection.getContentLength();
		InputStream is = connection.getInputStream();
		//读取联接中的数据
		byte[] buffer = new byte[len];
		is.read(buffer);
		is.close();

		//将数据存储到本地实现 文件下载
		FileOutputStream fos = new FileOutputStream("F:/hello.txt");
		fos.write(buffer);
		fos.close();
	}

}
