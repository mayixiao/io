package com.nio;

import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
 
//�ͻ���
public class MySocketChannel {

	public static void main(String[] args) throws Exception {
		//����socketchannel
		SocketChannel sc= SocketChannel.open();
		sc.configureBlocking(false);
		//�������ӷ���ĵ�ַ��˿� ��������
		boolean b = sc.connect(new InetSocketAddress("127.0.0.1",8888));
		//b�����ڽ����У���Ϊ������ģʽ Ϊfalse
		
		
		System.out.println("client " +b);
		
		sc.finishConnect();//�������ӵ���ɹ��� ������ģʽ true�����ӳɹ�
		
		System.out.println("client22 " +sc.finishConnect());
	}
}
