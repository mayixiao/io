package com.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MySocket {
	public static void main(String[] args) throws Exception {
		//����socket
		Socket s = new Socket("127.0.0.1",8888);
		OutputStream os = s.getOutputStream();
		
		//����������ȡ���������������� 
		InputStream is = s.getInputStream();
		//��������һ��
		os.write("��ã���ӭ��������1��".getBytes());
		
		byte[] bytes = new byte[1024];
		int len =-1;
		while((len=is.read(bytes))!=-1){
			//���յ�����˵Ļ�ִ��
			System.out.println("���ջ�ִ ��"+new String(bytes,0,len));
			String msg = "from client:" +new String(bytes,0,len);
			//����������  ���ٽ��Ÿ��������˷��� �ﵽ��ͣ�ķ���Ч��
			os.write(msg.getBytes());
			Thread.sleep(1000);
		}
		os.close();
		s.close();
		
	}
}
