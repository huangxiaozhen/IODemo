package me.huangzhen.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//��׼�������������
//System.out
//System.IN

public class SystemInOut
{
	public static void main(String[] args) throws IOException
	{
		//�Ӽ��̱�׼����Ķ����ֽ���
		
		//1. �����ֽ������д���
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
		
		//2. �ֽ���ת�����ַ������д��� ��Ļ����Խӵ��ֽ�����һ��ת���ַ������д���
		
		//1. ��ȡ��Ļ������ֽ����еĽڵ��� �������
		InputStream is = System.in;
		
		//2. ���ֽ���ת�����ַ����͵Ľڵ���
		InputStreamReader isr = new InputStreamReader(is);
		
		//3.�����װһ�㻺����
		BufferedReader br = new BufferedReader(isr);
		
		//���� br �Ķ�ȡһ�еķ����������ַ������н���
		String str;
		while( true )
		{
			System.out.println( "��Ӽ�������һ���ַ���" );
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
