package me.huangzhen.io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

//�Ӵ�������ĵ�λ�Ĳ�ͬ��io �п��Էֳ��ֽ����Լ��ַ���

/*
 * ʹ�� FileReader FileWriter ����ʵ���ı��ļ��ĸ���  txt �ļ���ʽ��  ֻ��ʵ���ı��ļ��ĸ���
 * ʹ�� FileInputStream FileOutputStream ����ʵ�ַ��ı��ļ��ĸ���  ���磺 ��Ƶ�����֣�ͼƬ��
 */

public class FileReaderWriter
{
	
	//����ͨ�õ�copy����
	@Test
	public void test3()
	{
		String src = "test2.txt";
		String dest = "test3.txt";
		copyFile(src, dest);
	}
	
	
	// �ı��ļ��ĸ����ƿ���д��ͨ�õķ���
	public void copyFile(String src, String dest)
	{
		File file1 = new File(src);
		File file2 = new File(dest);

		FileReader fr = null;
		FileWriter fw = null;

		try
		{
			fr = new FileReader(file1);
			fw = new FileWriter(file2);

			char[] c = new char[24];
			int len;
			while ((len = fr.read(c)) != -1)
			{
				fw.write(c, 0, len);
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			//�ر������
			if (fw != null)
			{
				try
				{
					fw.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}

			}
            //�ر�������
			if (fr != null)
			{
				try
				{
					fr.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	// �ı��ַ����ļ�����
	@Test
	public void test2()
	{
		// 1. ���� File �࣬����Դ�ļ���Ŀ���ļ�
		// ע�⣬����Դ�ļ�������ڣ�Ŀ���ļ����Բ�����
		File file1 = new File("test.txt");
		File file2 = new File("test2.txt");

		// 2. �����ַ������������
		FileReader fr = null;
		FileWriter fw = null;

		try
		{
			fr = new FileReader(file1);
			fw = new FileWriter(file2);

			char[] c = new char[24];
			int len;
			while ((len = fr.read(c)) != -1)
			{
				fw.write(c, 0, len);
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			if (fw != null)
			{
				try
				{
					fw.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}

			}

			if (fr != null)
			{
				try
				{
					fr.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}

			}
		}
	}

	@Test
	public void test1()
	{
		// 1. ���� File �ָ࣬��Ҫ������ļ���λ��
		File file = new File("test.txt");

		// 2. ���� FileReader �࣬���������ַ�
		FileReader fr = null;

		try
		{
			fr = new FileReader(file);
			// 3. �����ַ����飬ÿ�ζ�ȡ���ַ���Ŀ
			char[] c = new char[24];

			// 4. ���� filereader �з������в���
			int len;
			while ((len = fr.read(c)) != -1)
			{
				String string = new String(c, 0, len);
				System.out.println(string);
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		// 5. �����쳣�Ĵ���
		{
			if (fr != null)
			{
				try
				{
					fr.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}

		}
	}

}
