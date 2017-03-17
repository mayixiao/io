package com.nio;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

public class MyServerSocketChannel {

	//iosocket 
	public void ioSocket() throws Exception {
		
		//服务端
		java.net.ServerSocket ss = new java.net.ServerSocket(8888);   //tcp
		Socket socket  = ss.accept();//接受联接请求         //stream   基于流的          //阻塞
		
		
		//客户端
		Socket s = new Socket("127.0.0.1",8888);
		
	}
	
	//新的niosocketChanel
	@Test
	public void nioSocketChannel() throws Exception{
		
		//打开一个挑选器
		Selector selector = Selector.open();
		
		//开启服务器socket 通道 但未绑定
		ServerSocketChannel ssc = ServerSocketChannel.open();
		//创建绑定地址
		SocketAddress socketaddress = new InetSocketAddress("127.0.0.1",8888);
		//进行绑定
		ssc.bind(socketaddress);
		
		ssc.configureBlocking(false);  //设置为非阻塞方式,如果为true 那么就为传统的阻塞方式
		
		//在挑选器中注册 ssc,指定SelectionKey.OP_ACCEPT
		ssc.register(selector, SelectionKey.OP_ACCEPT);
		
		
		//接收联接请求
//		SocketChannel sc = ssc.accept();
//		
//		System.out.println("over :"+sc);//返回null说明 未阻塞
		
//		while(true){//一直接收 
//			SocketChannel sc = ssc.accept();
//			System.out.println("over :"+sc);//返回null说明 未阻塞
//			Thread.sleep(2000);
//		}
		
		
		SocketChannel chTmp = null;
		
		//缓冲区
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		
		
		while(true){
			selector.select();
			
			Set<SelectionKey> selKeys = selector.selectedKeys();
		
			Iterator<SelectionKey> it = selKeys.iterator();
			while(it.hasNext()){
				SelectionKey key = it.next();
				//判断ssc是否发生了accept事件
				if(key.isAcceptable()){
					ServerSocketChannel ch=(ServerSocketChannel)key.channel();
					chTmp = ch.accept();
					chTmp.register(selector, SelectionKey.OP_CONNECT|SelectionKey.OP_CONNECT|SelectionKey.OP_READ);
				}
				
				if(key.isConnectable()){
					chTmp = (SocketChannel)key.channel();
					System.out.println("chTmp "+ ": Connectable");
				}
				
				if(key.isReadable()){
					chTmp = (SocketChannel)key.channel();
					byteBuffer.clear();
					
					int len = chTmp.read(byteBuffer);
					
					if(len==-1){
						key.cancel();
						System.out.println(" client channel closed!");
					}
					else if(len >0){
						byteBuffer.flip();
						byte [] arr= byteBuffer.array();
						String str = new String(arr,0,byteBuffer.limit());
						System.out.println(" from client :"+chTmp +" "+ str );
						byteBuffer.clear();
					}
				}
				
				
				//148节
				System.out.println(key);
				it.remove();
			}
		
		}
	}
}
