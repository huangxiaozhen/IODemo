package me.huangzhen.io;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/*
 * 
 * 抽象基类          节点流               缓冲流(处理流)
 * InputStream       FileInputStream      bufferedInputStream
 * OutputStream      FileOutputStram      bufferedOutputStream(写完之后加上 flush)
 * Reader            FileReader           bufferedReader readLine
 * Writer            FileWriter           bufferedWriter  (写完之后加上 flush)
 * 
 */

public class BufferedStream
{
	
	
	//使用缓冲流进行 文本文件的复制  这里面需要注意两点
	// 1. bufferedReader 多了一个readLine 的方法
	// BufferedWriter 需要换行 ，调用newLIne()的方法
	@Test
	public void test2()
	{
		String src = "test3.txt";
		String dest = "test4.txt";
		bufferedCopyFile(src, dest);
	}
	
	public void bufferedCopyFile(String src,String dest)
	{
		// 1.定义源文件以及目标文件
		File file1 = new File(src);
		File file2 = new File(dest);
		
		//2. 定义字符缓冲流
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try
		{
			//3. 定义字节流，传入要操作的文件参数
			FileReader fr = new FileReader(file1);
			FileWriter fw = new FileWriter(file2);
			
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			
			//4. 注意进行读一行的操作
			String str;
			while( ( str = br.readLine() ) != null )
			{
				bw.write(str);
				//5 .注意这里需要换行
				bw.newLine();
			}
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}finally
		{
			//6. 关闭缓冲输出流
			if( bw != null )
			{
				try
				{
					bw.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			//关闭缓冲输入流
			if( br != null )
			{
				try
				{
					br.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			
		}
	}
	

	//使用缓冲流进行文件的复制
	@Test
	public void test()
	{
		//1. 定义 File 源文件和目标文件
		File file1 = new File("customer.jpg");
		File file2 = new File("customer2.jpg");
		
		//2. 定义缓冲处理流
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try
		{
			//3. 定义 字节流，直接作用到File上
			FileInputStream fis = new FileInputStream(file1);
			FileOutputStream fos = new FileOutputStream(file2);
			
			//4. 将字节流放在缓冲流中，可以加快文件的复制速度
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			//5. 利用缓冲流类的读写方法，进行文件的复制
			byte[] b = new byte[1024];
			int len;
			while(( len = bis.read( b ) ) != -1 )
			{
				bos.write(b, 0, len);
				bos.flush();
			}
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}finally{
			//6. 关闭输出流
			if( bos != null )
			{
				try
				{
					bos.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			//关闭输入流
			if( bos != null )
			{
				try
				{
					bos.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
