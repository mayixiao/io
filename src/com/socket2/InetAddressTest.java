package com.socket2;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.InterfaceAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	/**
	 * @��������: 2017��02��06��11:38:21 AM
	 *
	 * @����:
	 * @����ֵ:
	 *
	 * @�޸ļ�¼���޸�ʱ�䡢���ߡ�ԭ�򣩣�
	 */
	public static void main(String[] args) {
		try {
			//InetAddress��װ����������ip��ַ ��ͨ����̬�����õ��� �����˿�
			InetAddress ia =InetAddress.getLocalHost();
			System.out.println("hostName: "+ia.getHostName());
			System.out.println("hostAddres: "+ia.getHostAddress());
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
