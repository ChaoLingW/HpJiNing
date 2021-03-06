package com.hpe.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class FileReaderWirterTest {

	@Test
	public void testFileReader(){
		
		//FileReader 输入流、字符流、节点流
		File file = new File("hello.txt");
		FileReader fr = null;
		
		try {
			fr= new FileReader(file);
			char[] c = new char[10];
			int len;
			
			while((len = fr.read(c)) != -1){
				//方式一：转化为字符串
				String str = new String(c, 0, len);
				System.out.print(str);
				//方式二：利用for循环
				/*for(int i = 0; i < len; i ++){
					System.out.print(c[i]);
				}*/
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(fr != null)
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
	}
	
	@Test
	public void testFileWriter(){
		
		//FileWriter 输出流，字符流，节点流
		FileWriter fw= null;
		
		try {
			fw = new FileWriter("hello1.txt",true);
			
			fw.write("星期一\n星期二");
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(fw != null)
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	@Test
	public void testFileReaderWriter(){
		
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader(new File("hello.txt"));
			fw = new FileWriter("hello2.txt");
			
			char[] c = new char[10];
			int len;
			
			while((len = fr.read(c)) != -1){
				fw.write(c, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fw != null)
					fw.close();
				if(fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
}
