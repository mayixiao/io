package com.socket;

import java.io.InputStream;
import java.io.OutputStream;
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
		//向客户端发数据
		OutputStream os = s.getOutputStream();
		byte[] bytes = new byte[1024];
		
		int len =-1;
		
		while((len=is.read(bytes))!=-1){
			System.out.println("收到消息 ："+new String(bytes,0,len));
			
			String msg = "from server:" +new String(bytes,0,len);
			//输出到客户端 上到消息 后，再给客户端一个消息 
			os.write(msg.getBytes());
		}
		
		System.out.println("流关闭了");
		is.close();
		s.close();
		ss.close();
		
	}
}
