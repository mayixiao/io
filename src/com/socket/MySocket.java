package com.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MySocket {
	public static void main(String[] args) throws Exception {
		//创建socket
		Socket s = new Socket("127.0.0.1",8888);
		OutputStream os = s.getOutputStream();
		
		//输入流，读取服务器发来的数据 
		InputStream is = s.getInputStream();
		//先主动发一次
		os.write("你好，欢迎你来北京1！".getBytes());
		
		byte[] bytes = new byte[1024];
		int len =-1;
		while((len=is.read(bytes))!=-1){
			//接收到服务端的回执后
			System.out.println("接收回执 ："+new String(bytes,0,len));
			String msg = "from client:" +new String(bytes,0,len);
			//输出到服务端  ，再接着给服务器端发送 达到不停的发送效果
			os.write(msg.getBytes());
			Thread.sleep(1000);
		}
		os.close();
		s.close();
		
	}
}
