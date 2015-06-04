package me.huangzhen.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//标准的输入输出功能
//System.out
//System.IN

public class SystemInOut
{
	public static void main(String[] args) throws IOException
	{
		//从键盘标准输入的都是字节流
		
		//1. 按照字节流进行处理
		/*InputStream is =  System.in;
		BufferedInputStream bis = new BufferedInputStream(is);
		byte[] b = new byte[1024];
		int len;
		String str;
		while(true)
		{
			len = bis.read(b);
			str = new String(b, 0, len);
			if (str.equalsIgnoreCase("e") || str.equalsIgnoreCase("exit"))
			{
				break;
			}
			String str1 = str.toUpperCase();
			System.out.println(str1);
		}*/
		
		//2. 字节流转换成字符流进行处理 屏幕输入对接的字节流，一般转成字符流进行处理
		
		//1. 获取屏幕输入的字节流行的节点流 抽象基类
		InputStream is = System.in;
		
		//2. 将字节流转换成字符流型的节点流
		InputStreamReader isr = new InputStreamReader(is);
		
		//3.外面包装一层缓冲流
		BufferedReader br = new BufferedReader(isr);
		
		//调用 br 的读取一行的方法，利用字符串进行接收
		String str;
		while( true )
		{
			System.out.println( "请从键盘输入一串字符：" );
			str = br.readLine();
			if ( str.equalsIgnoreCase("e") || str.equalsIgnoreCase("exit") )
			{
				break;
			}
			
			String str1 = str.toUpperCase();
			System.out.println(str1);
			
		}
		
	}
}
