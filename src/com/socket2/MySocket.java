package com.socket2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class MySocket {
	public static void main(String[] args) throws Exception {
		//����socket
		Socket s = new Socket("127.0.0.1",8888);
		OutputStream os = s.getOutputStream();
		//�ӿ���̨��������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String line = br.readLine();
			//���� exit ʱ�˳�
			if(line !=null && "exit".equals(line)){
				break;
			}
			if(line != null){
				//����������  
				os.write(line.getBytes());
			}
		}
		os.close();
		s.close();
		
	}
}
