package com.socket2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SessionThread extends Thread {

	private Socket socket;
	
	public SessionThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run(){
		try {
			//����Զ�˵�ip
			InetAddress addr = socket.getInetAddress();
			System.out.println(addr);
			
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			os.write("��Һ�".getBytes());
			byte[] bytes = new byte[1024];
			int len =-1;
			while((len=is.read(bytes))!=-1){
				System.out.println("�յ���Ϣ"+addr.getHostAddress()+":"+socket.getPort()+"����Ϣ>>>"+"\""+new String(bytes,0,len)+"\"");
				//Ȼ���յ�����Ϣ�ٷ��͸��ͻ���
				//os.write(bytes,0,len);
			}
			
		} catch (IOException e) {
			System.out.println("�쳣�����ˣ�");
			//e.printStackTrace();
		}
		
	}
}
