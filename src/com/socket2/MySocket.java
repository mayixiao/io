package com.socket2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class MySocket {
	public static void main(String[] args) throws Exception {
		//创建socket
		Socket s = new Socket("127.0.0.1",8888);
		OutputStream os = s.getOutputStream();
		//从控制台输入数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String line = br.readLine();
			//输入 exit 时退出
			if(line !=null && "exit".equals(line)){
				break;
			}
			if(line != null){
				//输出到服务端  
				os.write(line.getBytes());
			}
		}
		os.close();
		s.close();
		
	}
}
