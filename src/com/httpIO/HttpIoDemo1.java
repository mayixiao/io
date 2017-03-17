package com.httpIO;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

//���ļ����� ���߳�
public class HttpIoDemo1 {

	public static void main(String[] args) throws Exception {
		String strUrl= "http://localhost:3636/hello.avi";//���ļ��ŵ�tomcat/webapp/root��
		URL url = new URL(strUrl);
		HttpURLConnection connection =  (HttpURLConnection)url.openConnection();
		
		InputStream is = connection.getInputStream();
		//��ȡ�����е�����
		byte[] buffer = new byte[1024];
		int len =-1;
		
		//�����ݴ洢������ʵ�� �ļ�����
		FileOutputStream fos = new FileOutputStream("F:/hello.avi");
		while ((len=is.read(buffer))!=-1) {
			fos.write(buffer);
		}
		fos.close();
	}
}
