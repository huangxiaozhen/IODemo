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
 * �������          �ڵ���               ������(������)
 * InputStream       FileInputStream      bufferedInputStream
 * OutputStream      FileOutputStram      bufferedOutputStream(д��֮����� flush)
 * Reader            FileReader           bufferedReader readLine
 * Writer            FileWriter           bufferedWriter  (д��֮����� flush)
 * 
 */

public class BufferedStream
{
	
	
	//ʹ�û��������� �ı��ļ��ĸ���  ��������Ҫע������
	// 1. bufferedReader ����һ��readLine �ķ���
	// BufferedWriter ��Ҫ���� ������newLIne()�ķ���
	@Test
	public void test2()
	{
		String src = "test3.txt";
		String dest = "test4.txt";
		bufferedCopyFile(src, dest);
	}
	
	public void bufferedCopyFile(String src,String dest)
	{
		// 1.����Դ�ļ��Լ�Ŀ���ļ�
		File file1 = new File(src);
		File file2 = new File(dest);
		
		//2. �����ַ�������
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try
		{
			//3. �����ֽ���������Ҫ�������ļ�����
			FileReader fr = new FileReader(file1);
			FileWriter fw = new FileWriter(file2);
			
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			
			//4. ע����ж�һ�еĲ���
			String str;
			while( ( str = br.readLine() ) != null )
			{
				bw.write(str);
				//5 .ע��������Ҫ����
				bw.newLine();
			}
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}finally
		{
			//6. �رջ��������
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
			//�رջ���������
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
	

	//ʹ�û����������ļ��ĸ���
	@Test
	public void test()
	{
		//1. ���� File Դ�ļ���Ŀ���ļ�
		File file1 = new File("customer.jpg");
		File file2 = new File("customer2.jpg");
		
		//2. ���建�崦����
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try
		{
			//3. ���� �ֽ�����ֱ�����õ�File��
			FileInputStream fis = new FileInputStream(file1);
			FileOutputStream fos = new FileOutputStream(file2);
			
			//4. ���ֽ������ڻ������У����Լӿ��ļ��ĸ����ٶ�
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			//5. ���û�������Ķ�д�����������ļ��ĸ���
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
			//6. �ر������
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
			//�ر�������
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
