package com.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SocketChannel;
 
//�ͻ���
public class MySocketChannel2 {

	public static void main(String[] args) throws Exception {
		
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		ReadableByteChannel channel = Channels.newChannel(System.in);
		//����socketchannel
		SocketChannel sc= SocketChannel.open(new InetSocketAddress("127.0.0.1",8888));
		 
		while(true){
			channel.read(byteBuffer);//��ͨ���ж�ȡ����
			byteBuffer.flip();
			sc.write(byteBuffer);//д��sc��
			byteBuffer.clear();
		}
		
	}
}
