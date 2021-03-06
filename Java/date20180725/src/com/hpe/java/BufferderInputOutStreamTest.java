package com.hpe.java;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class BufferderInputOutStreamTest {
	
	
	@Test
	public void testBufferedInputStream(){
		
		//BufferedInputSteram 输入流、字节流、处理流(缓冲流)
		//1.创建file
		File file = new File("1.txt");
		
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		//BufferedInputStream bis1 = new BufferedInputStream(new FileInputStream(new File("1.txt"))); 
		try {
			//2.创建FileInputStream
			fis = new FileInputStream(file);
			//3.创建BufferedInputStream
			bis = new BufferedInputStream(fis);
			
			byte[] b = new byte[2];
			int len;
			//使用BufferedInputStream读
			while((len = bis.read(b)) != -1){
				String str = new String(b, 0, len);
				System.out.print(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				//对于处理流，只需要关闭的处理流就可以，它对应的节点流就会自动关闭
				if(bis != null)
					bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testBufferedOutPutSream(){
		
		//BufferedOutputStream 输出流、字节流、处理流(处理流)
		BufferedOutputStream bos = null;
		
		try {
			bos = new BufferedOutputStream(new FileOutputStream("2.txt",true));
			
			String str = "poiuyt";
			
			bos.write(str.getBytes());
			
			bos.flush();//将缓存区的内容输出
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bos != null)
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	
	@Test
	public void testBufferderInputOutStream(){
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			bis = new BufferedInputStream(new FileInputStream("1.png"));
			bos = new BufferedOutputStream(new FileOutputStream("11.png"));
			
			byte[] b = new byte[1024];
			int len;
			
			while((len = bis.read(b)) != -1){
				//写
				bos.write(b,0,len);
				bos.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bos != null)
					bos.close();
				if(bis != null)
					bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
