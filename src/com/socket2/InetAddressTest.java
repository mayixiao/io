package com.socket2;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.InterfaceAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	/**
	 * @创建日期: 2017年02月06日11:38:21 AM
	 *
	 * @参数:
	 * @返回值:
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
	public static void main(String[] args) {
		try {
			//InetAddress封装了主机名和ip地址 是通过静态方法得到的 不含端口
			InetAddress ia =InetAddress.getLocalHost();
			System.out.println("hostName: "+ia.getHostName());
			System.out.println("hostAddres: "+ia.getHostAddress());
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
