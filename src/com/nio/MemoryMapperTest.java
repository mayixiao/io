package com.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

import org.junit.Test;

public class MemoryMapperTest {
	FileChannel fileChannel;
	/**
	 * 读取映射的字节缓冲区
	 * @创建日期: 2017年01月18日11:38:26 PM
	 *
	 * @参数:
	 * @返回值:
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
	@Test
	public void readMappedMemoryBuffer() throws Exception {
		//随机访问文件
		RandomAccessFile randomAccessFile = new  RandomAccessFile("F:/test.txt","rw");
		//得到文件 通道
		FileChannel fc = randomAccessFile.getChannel();
		
		System.out.println("fileLength :"+randomAccessFile.length());
		
		//将文件 都映射到内存中 0  -randomAccessFile.length()
		//创建与file相对应 的内存缓冲区   //只读
		MappedByteBuffer buf = fc.map(MapMode.READ_ONLY, 0, randomAccessFile.length());
		
		int cap = buf.capacity();//缓冲区容量
		
		System.out.println("buffer cap :" +cap);
		
		
		//复制上面的文件 
		//新建的通道 
		FileChannel fcout = new RandomAccessFile("F:/test2.txt","rw").getChannel();
		fcout.write(buf);
		fcout.close();
		
	}
	/**
	 * 对映射内存缓冲修改 同步到file中
	 * @创建日期: 2017年01月18日11:53:09 PM
	 *
	 * @参数:
	 * @返回值:
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
	@Test
	public void writeMappedMemoryBuffer() throws Exception {
		//随机访问文件
		RandomAccessFile randomAccessFile = new  RandomAccessFile("F:/test2.txt","rw");
		//得到文件 通道
		FileChannel fc = randomAccessFile.getChannel();
		
		System.out.println("fileLength :"+randomAccessFile.length());
		
		//将文件 都映射到内存中 0  -randomAccessFile.length()
		//创建与file相对应 的内存缓冲区     //读写
		MappedByteBuffer buf = fc.map(MapMode.READ_WRITE, 0, randomAccessFile.length());
		
		int cap = buf.capacity();//缓冲区容量
		
		for(int i = 20;i<40;i++){
			buf.put(i, (byte)1); //修改文件
		}
		fc.close();
		randomAccessFile.close();
	}
}
