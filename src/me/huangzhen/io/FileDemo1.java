package me.huangzhen.io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.junit.Test;

// 讲解 file 类的一些知识
// java 关于输入/输出的都定义在 java.io 包下。
// java.io.File 是一个类，可以创建对象。此对象对应一个文件(.txt,.avi,.doc,.mp3,.jpg),或者对应
// 一个文件目录. 文件表示成 java 的一个对象 ，java 中在操作对象，就是操作这个文件。
// 3. FILE 类对象与平台无关 
// 4. File 中的方法仅涉及到如何 创建，删除，重命名等等；
//只要涉及到文件内容，内容是什么？能够修改？ File 做不了，必须有 IO 流来完成 

//5. File 类的对象 常作为 IO流 具体类的形参，进行输入输出时，从哪里输入，输出到哪里？
public class FileDemo1
{

	// File 类常用方法第三波
	@Test
	public void test3() throws IOException
	{
		File file1 = new File("e:\\io\\hello.txt");
		boolean b1 = file1.delete();
		System.out.println("^^" + b1);

		if (!file1.exists())
		{
			boolean b2 = file1.createNewFile();
			System.out.println(b2);
		}

		//如果上层目录存在，则创建新的文件目录使用 mkdir
		File file2 = new File("e:\\io\\io2");
		if (!file2.exists())
		{
			file2.mkdir();

		}
		
		//如果上层目录不存在，则创建新的文件目录使用 mkdirs ,上层不存在的目录也一并创建
		//也一并创建
		File file3 = new File("e:\\io1\\io2");
		if ( !file3.exists() )
		{
			file3.mkdirs();
		}
		
		//list
		File file4 = new File("e:\\CRM");
		String[] strings =  file4.list();
		for(String string : strings)
		{
			System.out.println(string);
		}
		
		//filelist
		File[] files = file4.listFiles();
		for(File file : files)
		{
			System.out.println( file.getPath() );
		}
 		

	}

	// File 类常用方法第二波
	@Test
	public void test1()
	{
		File file1 = new File("e:\\io\\hello.txt");
		File file2 = new File("e:\\io\\io1");

		System.out.println(file1.exists());
		System.out.println(file1.canRead());
		System.out.println(file1.canWrite());
		System.out.println(file1.isFile());
		System.out.println(file1.isDirectory());
		System.out.println(file1.lastModified());
		System.out.println(file1.length());

		System.out.println();

		System.out.println(file2.exists());
		System.out.println(file2.canRead());
		System.out.println(file2.canWrite());
		System.out.println(file2.isFile());
		System.out.println(file2.isDirectory());
		System.out.println(file2.lastModified());
		System.out.println(file2.length());

	}

	@Test
	public void test()
	{
		// 这里的 pathname 的 路径名该如何填写
		// 为了使程序具有跨平台性
		// java 程序中用两个 \\ 或 /

		/*
		 * 路径又分成两种 1. 绝对类型 包含盘符在类的完成的文件路径 2. 相对路径，在当前文件目录下的路径
		 */
		File file1 = new File("e:\\io\\hello.txt");
		File file2 = new File("hello2.txt");
		File file3 = new File("e:\\io\\io1");

		// File 类常用方法 第一波

		System.out.println(file1.getName());
		System.out.println(file1.getPath());
		System.out.println(file1.getAbsoluteFile());
		System.out.println(file1.getAbsolutePath());
		System.out.println(file1.getParent());

		System.out.println();

		System.out.println(file3.getName());
		System.out.println(file3.getPath());
		System.out.println(file3.getAbsoluteFile());
		System.out.println(file3.getAbsolutePath());
		System.out.println(file3.getParent());

		// Ps! fil1.renanme( file2 ) 需要保证 file1 一定存在 file2 一定要不存在才行

		// 可以是相对路径转绝对路径 file2 -->file 也可以是绝对路径转相对路径 file -- > file2
		// 但一定要确保 文件 《--》 文件 或者是 文件目录《--》文件目录
		boolean b = file1.renameTo(file3);
		System.out.println(b);

	}

}
