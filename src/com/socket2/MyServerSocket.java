package com.socket2;

import java.net.ServerSocket;
import java.net.Socket;
//��������  ���߳� �����Բ��Ͻ��տͻ���
public class MyServerSocket {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(8888);
		System.out.println("�����������ˣ�");
		//������������
		while(true){
			Socket s = ss.accept();
			new SessionThread(s).start();
		}
		
		
	}
}
