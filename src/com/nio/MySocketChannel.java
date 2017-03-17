package com.nio;

import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
 
//客户端
public class MySocketChannel {

	public static void main(String[] args) throws Exception {
		//开启socketchannel
		SocketChannel sc= SocketChannel.open();
		sc.configureBlocking(false);
		//配置联接服务的地址与端口 进行连接
		boolean b = sc.connect(new InetSocketAddress("127.0.0.1",8888));
		//b连接在进行中，且为非阻塞模式 为false
		
		
		System.out.println("client " +b);
		
		sc.finishConnect();//处理联接的完成工作 非阻塞模式 true则连接成功
		
		System.out.println("client22 " +sc.finishConnect());
	}
}
