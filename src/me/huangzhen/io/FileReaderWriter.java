package me.huangzhen.io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

//从处理输入的单位的不同，io 中可以分成字节流以及字符流

/*
 * 使用 FileReader FileWriter 可以实现文本文件的复制  txt 文件格式等  只能实现文本文件的复制
 * 使用 FileInputStream FileOutputStream 可以实现非文本文件的复制  例如： 视频，音乐，图片等
 */

public class FileReaderWriter
{
	
	//测试通用的copy方法
	@Test
	public void test3()
	{
		String src = "test2.txt";
		String dest = "test3.txt";
		copyFile(src, dest);
	}
	
	
	// 文本文件的赋复制可以写成通用的方法
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
			//关闭输出流
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
            //关闭输入流
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

	// 文本字符的文件复制
	@Test
	public void test2()
	{
		// 1. 定义 File 类，包含源文件与目标文件
		// 注意，这里源文件必须存在，目标文件可以不存在
		File file1 = new File("test.txt");
		File file2 = new File("test2.txt");

		// 2. 定义字符的输入输出类
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
		// 1. 定义 File 类，指明要处理的文件的位置
		File file = new File("test.txt");

		// 2. 定义 FileReader 类，用来处理字符
		FileReader fr = null;

		try
		{
			fr = new FileReader(file);
			// 3. 定义字符数组，每次读取的字符数目
			char[] c = new char[24];

			// 4. 调用 filereader 中方法进行操作
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
		// 5. 进行异常的处理
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
