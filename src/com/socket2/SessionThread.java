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
			//返回远端的ip
			InetAddress addr = socket.getInetAddress();
			System.out.println(addr);
			
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			os.write("大家好".getBytes());
			byte[] bytes = new byte[1024];
			int len =-1;
			while((len=is.read(bytes))!=-1){
				System.out.println("收到消息"+addr.getHostAddress()+":"+socket.getPort()+"的消息>>>"+"\""+new String(bytes,0,len)+"\"");
				//然后将收到的信息再发送给客户端
				//os.write(bytes,0,len);
			}
			
		} catch (IOException e) {
			System.out.println("异常下线了！");
			//e.printStackTrace();
		}
		
	}
}
