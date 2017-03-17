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
		
		//�����
		java.net.ServerSocket ss = new java.net.ServerSocket(8888);   //tcp
		Socket socket  = ss.accept();//������������         //stream   ��������          //����
		
		
		//�ͻ���
		Socket s = new Socket("127.0.0.1",8888);
		
	}
	
	//�µ�niosocketChanel
	@Test
	public void nioSocketChannel() throws Exception{
		
		//��һ����ѡ��
		Selector selector = Selector.open();
		
		//����������socket ͨ�� ��δ��
		ServerSocketChannel ssc = ServerSocketChannel.open();
		//�����󶨵�ַ
		SocketAddress socketaddress = new InetSocketAddress("127.0.0.1",8888);
		//���а�
		ssc.bind(socketaddress);
		
		ssc.configureBlocking(false);  //����Ϊ��������ʽ,���Ϊtrue ��ô��Ϊ��ͳ��������ʽ
		
		//����ѡ����ע�� ssc,ָ��SelectionKey.OP_ACCEPT
		ssc.register(selector, SelectionKey.OP_ACCEPT);
		
		
		//������������
//		SocketChannel sc = ssc.accept();
//		
//		System.out.println("over :"+sc);//����null˵�� δ����
		
//		while(true){//һֱ���� 
//			SocketChannel sc = ssc.accept();
//			System.out.println("over :"+sc);//����null˵�� δ����
//			Thread.sleep(2000);
//		}
		
		
		SocketChannel chTmp = null;
		
		//������
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		
		
		while(true){
			selector.select();
			
			Set<SelectionKey> selKeys = selector.selectedKeys();
		
			Iterator<SelectionKey> it = selKeys.iterator();
			while(it.hasNext()){
				SelectionKey key = it.next();
				//�ж�ssc�Ƿ�����accept�¼�
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
				
				
				//148��
				System.out.println(key);
				it.remove();
			}
		
		}
	}
}
