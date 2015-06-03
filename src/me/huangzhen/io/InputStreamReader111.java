package me.huangzhen.io;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class InputStreamReader111
{
	
	
	
	/*
	 * 转换流 涉及到两个类 1. InputStreamReader 2. outPutStreamWriter
	 * 
	 * 解码： 字节流 --》 字符流
	 * 
	 * 编码： 字符流 --》 字节流
	 * 
	 * 最主要的作用可以设置字符的编码方式！
	 */

	@Test
	public void test() throws IOException  
	{
		//1. 定义要作用的文件 File 对象
		File file = new File("test3.txt");
		InputStreamReader isr=null;
		//2.开始默认的是字节流
		try
		{
			FileInputStream fis = new FileInputStream(file);
			//3.解码  字节流转换成字符流
			try
			{
				isr= new InputStreamReader(fis, "GBK");
			} catch (UnsupportedEncodingException e)
			{
				e.printStackTrace();
			}
			//4. 再用缓冲流进行包装，提高传输速度
			BufferedReader br = new BufferedReader(isr);
			
			//5.编码
			File file2 = new File("test6.txt");
			FileOutputStream fos = new FileOutputStream(file2);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");
			BufferedWriter bfw = new BufferedWriter(osw);
			
			String str;
			while( ( str = br.readLine() ) != null )
			{
				bfw.write(str);
				bfw.newLine();
				bfw.flush();
			}
			
			
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}

}
