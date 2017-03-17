package com.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SocketChannel;
 
//客户端
public class MySocketChannel2 {

	public static void main(String[] args) throws Exception {
		
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		ReadableByteChannel channel = Channels.newChannel(System.in);
		//开启socketchannel
		SocketChannel sc= SocketChannel.open(new InetSocketAddress("127.0.0.1",8888));
		 
		while(true){
			channel.read(byteBuffer);//从通道中读取数据
			byteBuffer.flip();
			sc.write(byteBuffer);//写到sc中
			byteBuffer.clear();
		}
		
	}
}
