package com.socket1;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
//��������
public class MyServerSocket {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(8888);
		//������������
		Socket s = ss.accept();
		
		System.out.println("���˽����ˣ�");
		//�õ�����������ȡ�ͻ�����������
		InputStream is = s.getInputStream();
		byte[] bytes = new byte[1024];
		
		int len =-1;
		
		while((len=is.read(bytes))!=-1){
			System.out.println("�յ���Ϣ ��"+new String(bytes,0,len));
		}
		
		System.out.println("���ر���");
		is.close();
		s.close();
		ss.close();
		
	}
}
