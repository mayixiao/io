package com.httpIO;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
//�ļ�����
public class HttpIoDemo {

	public static void main(String[] args) throws Exception {
//		String strUrl= "http://localhost:3636/hello.txt";
		String strUrl= "https://www.baidu.com/";
		URL url = new URL(strUrl);
		HttpURLConnection connection =  (HttpURLConnection)url.openConnection();
		int len = connection.getContentLength();
		InputStream is = connection.getInputStream();
		//��ȡ�����е�����
		byte[] buffer = new byte[len];
		is.read(buffer);
		is.close();

		//�����ݴ洢������ʵ�� �ļ�����
		FileOutputStream fos = new FileOutputStream("F:/hello.txt");
		fos.write(buffer);
		fos.close();
	}

}
