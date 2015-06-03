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
	 * ת���� �漰�������� 1. InputStreamReader 2. outPutStreamWriter
	 * 
	 * ���룺 �ֽ��� --�� �ַ���
	 * 
	 * ���룺 �ַ��� --�� �ֽ���
	 * 
	 * ����Ҫ�����ÿ��������ַ��ı��뷽ʽ��
	 */

	@Test
	public void test() throws IOException  
	{
		//1. ����Ҫ���õ��ļ� File ����
		File file = new File("test3.txt");
		InputStreamReader isr=null;
		//2.��ʼĬ�ϵ����ֽ���
		try
		{
			FileInputStream fis = new FileInputStream(file);
			//3.����  �ֽ���ת�����ַ���
			try
			{
				isr= new InputStreamReader(fis, "GBK");
			} catch (UnsupportedEncodingException e)
			{
				e.printStackTrace();
			}
			//4. ���û��������а�װ����ߴ����ٶ�
			BufferedReader br = new BufferedReader(isr);
			
			//5.����
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
