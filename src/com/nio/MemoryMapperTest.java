package com.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

import org.junit.Test;

public class MemoryMapperTest {
	FileChannel fileChannel;
	/**
	 * ��ȡӳ����ֽڻ�����
	 * @��������: 2017��01��18��11:38:26 PM
	 *
	 * @����:
	 * @����ֵ:
	 *
	 * @�޸ļ�¼���޸�ʱ�䡢���ߡ�ԭ�򣩣�
	 */
	@Test
	public void readMappedMemoryBuffer() throws Exception {
		//��������ļ�
		RandomAccessFile randomAccessFile = new  RandomAccessFile("F:/test.txt","rw");
		//�õ��ļ� ͨ��
		FileChannel fc = randomAccessFile.getChannel();
		
		System.out.println("fileLength :"+randomAccessFile.length());
		
		//���ļ� ��ӳ�䵽�ڴ��� 0  -randomAccessFile.length()
		//������file���Ӧ ���ڴ滺����   //ֻ��
		MappedByteBuffer buf = fc.map(MapMode.READ_ONLY, 0, randomAccessFile.length());
		
		int cap = buf.capacity();//����������
		
		System.out.println("buffer cap :" +cap);
		
		
		//����������ļ� 
		//�½���ͨ�� 
		FileChannel fcout = new RandomAccessFile("F:/test2.txt","rw").getChannel();
		fcout.write(buf);
		fcout.close();
		
	}
	/**
	 * ��ӳ���ڴ滺���޸� ͬ����file��
	 * @��������: 2017��01��18��11:53:09 PM
	 *
	 * @����:
	 * @����ֵ:
	 *
	 * @�޸ļ�¼���޸�ʱ�䡢���ߡ�ԭ�򣩣�
	 */
	@Test
	public void writeMappedMemoryBuffer() throws Exception {
		//��������ļ�
		RandomAccessFile randomAccessFile = new  RandomAccessFile("F:/test2.txt","rw");
		//�õ��ļ� ͨ��
		FileChannel fc = randomAccessFile.getChannel();
		
		System.out.println("fileLength :"+randomAccessFile.length());
		
		//���ļ� ��ӳ�䵽�ڴ��� 0  -randomAccessFile.length()
		//������file���Ӧ ���ڴ滺����     //��д
		MappedByteBuffer buf = fc.map(MapMode.READ_WRITE, 0, randomAccessFile.length());
		
		int cap = buf.capacity();//����������
		
		for(int i = 20;i<40;i++){
			buf.put(i, (byte)1); //�޸��ļ�
		}
		fc.close();
		randomAccessFile.close();
	}
}
