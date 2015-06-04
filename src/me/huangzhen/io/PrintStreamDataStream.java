package me.huangzhen.io;

import static org.junit.Assert.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

// ��ӡ����������

public class PrintStreamDataStream
{
	
	
	//3. �������е�д��
	@Test
	public void test3() throws IOException  
	{
		DataInputStream dis = null;
		try
		{
			dis = new DataInputStream( new FileInputStream( new File(  "data.txt" ) ) );
			//���ַ�ʽ���У�����Ļ�������
			//������������д���ʱ����ʲô��ʽ��������ʱ��Ҳ��Ҫ���ö�Ӧ��ʽ�ķ���
			/*byte[] b = new byte[20];
			int len;
			try
			{
				while( ( len = dis.read(b)  ) != -1 )
				{
					String string = new String( b,0,len );
					System.out.println(string);
				}
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			*/
			//����д���˳����ж���
			System.out.println( dis.readUTF()  );
			System.out.println( dis.readBoolean()  );
			System.out.println( dis.readInt() );
			
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}finally
		{
			if (dis!= null)
			{
				try
				{
					dis.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	//2. ������ ��������java�еĻ������������Լ�String��char������ dataInputStream and dataOutputStream
	//������д����������� dataoutputstram д������������͵�һ���ļ���
	@Test
	public void test2()
	{
		DataOutputStream dos=null;
		try
		{
			FileOutputStream fos = new FileOutputStream( new File( "data.txt" ) );
			dos = new DataOutputStream(fos);
			
			dos.writeUTF("����˭");
			dos.writeBoolean(true);
			dos.writeInt(11111);
		} catch (IOException e)
		{
			e.printStackTrace();
		}finally
		{
			if ( dos != null )
			{
				try
				{
					dos.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			
		}
	}

	//1. ���ڴ�ӡ�� PrintStream
	@Test
	public void test() throws FileNotFoundException
	{
		//1. ����Ҫ���õ�Ŀ���ļ� 
		File file = new File("test.txt");
		
		//2. �����ֽ��ļ������
		FileOutputStream fos = new FileOutputStream(file);
		
		//3.�����ӡ��
		PrintStream ps = new PrintStream(fos);
		
		//4.�������ô�ӡ����λ�ã����Ǵ�ӡ������̨
		if ( ps != null )
		{
			System.setOut(ps);
		}
		
		//5.����asc�Ĵ�ӡ
		for( int i = 0; i<255; i++ )
		{
			System.out.print( (char)i );
			
			if (i % 50 == 0)
			{
				System.out.println();
			}
		}
	}
}
