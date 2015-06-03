package me.huangzhen.io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

import org.junit.Test;

/**
 * 1.IO ���ķ��� ������������Ĳ�ͬ���Է�Ϊ�� ������/����� �������ݴ���λ�Ĳ�ͬ���Է�Ϊ�� �ֽ���/�ַ��� ���ս�ɫ����Ĳ�ͬ���Է�Ϊ��
 * �ڵ���(ֱ���������ļ���)/������
 * 
 * 2. ������� �ڵ������ļ����� InputStream FileInputStream OutputStream FileOutputStream
 * Reader FileReader Writer FileWriter
 *
 */

public class FileInOutStream
{
	
	//���Ը��Ƴ���
	@Test
	public void test5()
	{
		long start  = System.currentTimeMillis();
		String src =  "C:\\Users\\huangzhen\\Desktop\\1.mp3";
		String dest = "C:\\Users\\huangzhen\\Desktop\\2.mp3";
		copyFile(src, dest);
		long end  = System.currentTimeMillis();
		System.out.println( "����"  + src + "��" + dest + "������ʱ��Ϊ��" + (end-start));
	}
	
	
	// ʵ���ļ����Ƶķ���ͨ�õķ���
	public void copyFile(String src, String dest)
	{
		File file1 = new File(src);
		File file2 = new File(dest);

		FileInputStream fis = null;
		FileOutputStream fos = null;

		try
		{
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);

			byte[] b = new byte[20];
			int len;
			while ((len = fis.read(b)) != -1)
			{
				fos.write(b, 0, len);
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			if (fos != null)
			{
				try
				{
					fos.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}

			if (fis != null)
			{
				try
				{
					fis.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}

	}

	// ��һ���ļ���һ���ط���������һ���ط� ���൱���� java ����ʵ���ļ��ĸ��ƣ�
	@Test
	public void testCopyFile()
	{
		// 1. ����Ҫ�������ļ�λ�ã��Լ�Ҫ���Ƶ����ļ�λ��
		File file1 = new File("C:\\Users\\huangzhen\\Desktop\\customer.jpg");
		File file2 = new File("C:\\Users\\huangzhen\\Desktop\\customer2.jpg");

		// 2. ��������/�����
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try
		{
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);

			// 3. ���ж���д�Ĳ���
			byte[] b = new byte[2];
			int len;
			while ((len = fis.read(b)) != -1)
			{
				fos.write(b, 0, len);
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			// �ر���
			if (fos != null)
			{
				try
				{
					fos.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}

			if (fis != null)
			{
				try
				{
					fis.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}

	}

	// test4 ���
	@Test
	public void testOutputStream1()
	{
		// 1. ���� file ����� �� �������Ķ��󲻴��ڣ�����Զ����ɡ��������Ķ�����ڣ���Ḳ���Ѿ��е����ݡ�
		File file = new File("hello2.txt");

		// 2. ���� �ļ����������
		FileOutputStream fos = null;

		try
		{
			fos = new FileOutputStream(file);

			// 3. д����
			fos.write(new String("hello world!").getBytes());

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			if (fos != null)
			{
				try
				{
					// 4. �ر������
					fos.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	// read() ����һ�ζ�ȡһ���ֽڵ�Ч��̫�ͣ��ڿ����в���ʵ���õ������ǿ���ʹ��һ�ζ�ȡһ���ֽڵ�����
	// ���ֽ�������
	@Test
	public void testFileInputStream3()
	{
		FileInputStream fis = null;
		try
		{
			File file = new File("hello.txt");
			fis = new FileInputStream(file);
			byte[] b = new byte[5]; // ÿ������ȡ20���ֽ�
			int len; // ÿ��ʵ�ʶ�ȡ���ֽ���
			while ((len = fis.read(b)) != -1) // �ж��Ƿ��Ѿ���ȡ��
			{
				/*
				 * for( int i = 0;i< len ;i++ ) { System.out.print( (char)b[i]
				 * ); }
				 */

				// ��������2
				String str = new String(b, 0, len);
				System.out.print(str);

			}
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			if (fis != null)
			{
				try
				{
					fis.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	// �����쳣���� throws ����ķ�ʽ���á� ��Ϊ ���ǰ������쳣�����������Ϊϡ����Դ�����ܼ�ʱ�ر�
	// ����Ҫ�� try catch �������쳣��������û���쳣���֣������Ǻ����쳣���֣����Ƕ�Ҫ��֤�����ܹ���
	// �����Ĺر�
	@Test
	public void testInputStream2()
	{
		FileInputStream fis = null;
		try
		{
			File file = new File("hello.txt");
			fis = new FileInputStream(file);
			int b;
			while ((b = fis.read()) != -1)
			{
				System.err.println((char) b);
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				fis.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testInputStram() throws IOException
	{
		// Ҫ��ȡ���ļ�һ��Ҫ���ڣ������� FileNotFoundException

		// 1. ����һ��File��ָ���ļ���·�������������·�����߾���·��
		File file = new File("hello.txt");

		// 2. ����һ�� FileInputStream�����������ļ��е�����
		FileInputStream fis = new FileInputStream(file);

		// 3. ���� FileInputStram �еķ���
		/*
		 * read() ��ȡ�ļ���һ���ֽڣ���ִ�е���βʱ������ -1 ���˳�
		 */
		/*
		 * int i = fis.read() ; while ( i != -1 ) { System.out.println( (char)i
		 * ); i =fis.read(); }
		 */

		int b;
		while ((b = fis.read()) != -1)
		{
			System.err.println((char) b);
		}

		// 4. ��ʾ�Ĺر���
		fis.close();

		// PS��read ������һ���ֽڣ����Զ�ȡӢ���ַ�����������й������ܽ��ж�ȡ������ʾ����

	}

}
