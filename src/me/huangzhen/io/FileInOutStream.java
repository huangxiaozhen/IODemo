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
 * 1.IO 流的分类 按照数据流向的不同可以分为： 输入流/输出流 按照数据处理单位的不同可以分为： 字节流/字符流 按照角色处理的不同可以分为：
 * 节点流(直接作用在文件上)/处理流
 * 
 * 2. 抽象基类 节点流（文件流） InputStream FileInputStream OutputStream FileOutputStream
 * Reader FileReader Writer FileWriter
 *
 */

public class FileInOutStream
{
	
	//测试复制程序
	@Test
	public void test5()
	{
		long start  = System.currentTimeMillis();
		String src =  "C:\\Users\\huangzhen\\Desktop\\1.mp3";
		String dest = "C:\\Users\\huangzhen\\Desktop\\2.mp3";
		copyFile(src, dest);
		long end  = System.currentTimeMillis();
		System.out.println( "拷贝"  + src + "到" + dest + "所花的时间为：" + (end-start));
	}
	
	
	// 实现文件复制的方法通用的方法
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

	// 把一个文件从一个地方拷贝到另一个地方 （相当于用 java 程序实现文件的复制）
	@Test
	public void testCopyFile()
	{
		// 1. 定义要拷贝的文件位置，以及要复制到的文件位置
		File file1 = new File("C:\\Users\\huangzhen\\Desktop\\customer.jpg");
		File file2 = new File("C:\\Users\\huangzhen\\Desktop\\customer2.jpg");

		// 2. 定义输入/输出流
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try
		{
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);

			// 3. 进行读和写的操作
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
			// 关闭流
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

	// test4 输出
	@Test
	public void testOutputStream1()
	{
		// 1. 创建 file 类对象 。 若创建的对象不存在，则会自动生成。若创建的对象存在，则会覆盖已经有的内容。
		File file = new File("hello2.txt");

		// 2. 创建 文件输出流对象
		FileOutputStream fos = null;

		try
		{
			fos = new FileOutputStream(file);

			// 3. 写操作
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
					// 4. 关闭输出流
					fos.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	// read() 方法一次读取一个字节的效率太低，在开发中不会实际用到，我们可以使用一次读取一批字节到定义
	// 的字节数组中
	@Test
	public void testFileInputStream3()
	{
		FileInputStream fis = null;
		try
		{
			File file = new File("hello.txt");
			fis = new FileInputStream(file);
			byte[] b = new byte[5]; // 每次最多读取20个字节
			int len; // 每次实际读取的字节数
			while ((len = fis.read(b)) != -1) // 判断是否已经读取完
			{
				/*
				 * for( int i = 0;i< len ;i++ ) { System.out.print( (char)b[i]
				 * ); }
				 */

				// 遍历方法2
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

	// 处理异常，用 throws 处理的方式不好。 因为 如果前面出现异常，后面的流作为稀有资源，不能及时关闭
	// 我们要用 try catch 来处理异常，不管有没有异常出现，或者是何种异常出现，我们都要保证，流能够被
	// 正常的关闭
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
		// 要读取的文件一定要存在，否则抛 FileNotFoundException

		// 1. 创建一个File，指定文件的路径，可以是相对路径或者绝对路径
		File file = new File("hello.txt");

		// 2. 创建一个 FileInputStream，用来操作文件中的内容
		FileInputStream fis = new FileInputStream(file);

		// 3. 调用 FileInputStram 中的方法
		/*
		 * read() 读取文件的一个字节，当执行到结尾时，返回 -1 ，退出
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

		// 4. 显示的关闭流
		fis.close();

		// PS！read 读的是一个字节，可以读取英文字符，但如果是中国，不能进行读取，会显示乱码

	}

}
