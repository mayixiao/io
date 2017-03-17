package com.socket1;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
//服务器端
public class MyServerSocket {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(8888);
		//接收连接请求
		Socket s = ss.accept();
		
		System.out.println("有人进来了！");
		//得到输入流，读取客户端请求数据
		InputStream is = s.getInputStream();
		byte[] bytes = new byte[1024];
		
		int len =-1;
		
		while((len=is.read(bytes))!=-1){
			System.out.println("收到消息 ："+new String(bytes,0,len));
		}
		
		System.out.println("流关闭了");
		is.close();
		s.close();
		ss.close();
		
	}
}
