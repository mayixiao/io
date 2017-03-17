package com.io;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class InputStream {

	public static void main(String[] args) throws Exception {

		// /////////�ֽ���
		
		// һ�㴦����Ƶ��ͼƬʱʹ���ֽ���

		// ��ȡ�ļ�����
		FileInputStream fileInputStream = new FileInputStream("F:\\test.txt");

		// fileInputStream.read();
		byte[] bbuf = new byte[1024];
		int hasRead = 0;
		// ʹ��ѭ�����ظ���ȡˮ���Ĺ���
		while ((hasRead = fileInputStream.read(bbuf)) > 0) {
			// ȡ��"��Ͳ"��(�ֽ�),���ֽ�����ת���ַ�������
			System.out.println(new String(bbuf, 0, hasRead));
		}
		fileInputStream.close();

		// д�ļ�
		FileOutputStream fs = new FileOutputStream("F:\\test1.txt");
		fs.write("�л����񹲺͹�".getBytes());
		fs.close();
	}

	// �����ַ�������  //һ�� �����ļ�ʱʹ���ַ���  ��Ϊ�ֽ����迼�Ǳ�������
	@Test
	public void fileReadTest() throws IOException {
		FileReader fr = null;
		try {
			// �����ַ�������
			fr = new FileReader("F:\\test.txt");
			// ����һ������Ϊ32��"��Ͳ"
			char[] cbuf = new char[32];
			// ���ڱ���ʵ�ʶ�ȡ���ַ���
			int hasRead = 0;
			// ʹ��ѭ�����ظ���ȡˮ���Ĺ���
			while ((hasRead = fr.read(cbuf)) > 0) {
				// ȡ��"��Ͳ"��(�ֽ�),���ֽ�����ת���ַ�������
				System.out.println(new String(cbuf, 0, hasRead));
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			// �ر��ļ�������
			if (fr != null) {
				fr.close();
			}
		}
	}
}
