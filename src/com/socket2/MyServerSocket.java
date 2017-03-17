package com.socket2;

import java.net.ServerSocket;
import java.net.Socket;
//服务器端  多线程 ，可以不断接收客户端
public class MyServerSocket {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(8888);
		System.out.println("服务器启动了！");
		//接收连接请求
		while(true){
			Socket s = ss.accept();
			new SessionThread(s).start();
		}
		
		
	}
}
