package com.io;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class InputStream {

	public static void main(String[] args) throws Exception {

		// /////////字节流
		
		// 一般处理视频、图片时使用字节流

		// 读取文件内容
		FileInputStream fileInputStream = new FileInputStream("F:\\test.txt");

		// fileInputStream.read();
		byte[] bbuf = new byte[1024];
		int hasRead = 0;
		// 使用循环来重复“取水”的过程
		while ((hasRead = fileInputStream.read(bbuf)) > 0) {
			// 取出"竹筒"中(字节),将字节数组转成字符串输入
			System.out.println(new String(bbuf, 0, hasRead));
		}
		fileInputStream.close();

		// 写文件
		FileOutputStream fs = new FileOutputStream("F:\\test1.txt");
		fs.write("中华人民共和国".getBytes());
		fs.close();
	}

	// 创建字符输入流  //一般 处理文件时使用字符流  因为字节流需考虑编码问题
	@Test
	public void fileReadTest() throws IOException {
		FileReader fr = null;
		try {
			// 创建字符输入流
			fr = new FileReader("F:\\test.txt");
			// 创建一个长度为32的"竹筒"
			char[] cbuf = new char[32];
			// 用于保存实际读取的字符数
			int hasRead = 0;
			// 使用循环来重复“取水”的过程
			while ((hasRead = fr.read(cbuf)) > 0) {
				// 取出"竹筒"中(字节),将字节数组转成字符串输入
				System.out.println(new String(cbuf, 0, hasRead));
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			// 关闭文件输入流
			if (fr != null) {
				fr.close();
			}
		}
	}
}
