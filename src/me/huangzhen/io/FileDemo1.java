package me.huangzhen.io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.junit.Test;

// ���� file ���һЩ֪ʶ
// java ��������/����Ķ������� java.io ���¡�
// java.io.File ��һ���࣬���Դ������󡣴˶����Ӧһ���ļ�(.txt,.avi,.doc,.mp3,.jpg),���߶�Ӧ
// һ���ļ�Ŀ¼. �ļ���ʾ�� java ��һ������ ��java ���ڲ������󣬾��ǲ�������ļ���
// 3. FILE �������ƽ̨�޹� 
// 4. File �еķ������漰����� ������ɾ�����������ȵȣ�
//ֻҪ�漰���ļ����ݣ�������ʲô���ܹ��޸ģ� File �����ˣ������� IO ������� 

//5. File ��Ķ��� ����Ϊ IO�� ��������βΣ������������ʱ�����������룬��������
public class FileDemo1
{

	// File �ೣ�÷���������
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

		//����ϲ�Ŀ¼���ڣ��򴴽��µ��ļ�Ŀ¼ʹ�� mkdir
		File file2 = new File("e:\\io\\io2");
		if (!file2.exists())
		{
			file2.mkdir();

		}
		
		//����ϲ�Ŀ¼�����ڣ��򴴽��µ��ļ�Ŀ¼ʹ�� mkdirs ,�ϲ㲻���ڵ�Ŀ¼Ҳһ������
		//Ҳһ������
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

	// File �ೣ�÷����ڶ���
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
		// ����� pathname �� ·�����������д
		// Ϊ��ʹ������п�ƽ̨��
		// java ������������ \\ �� /

		/*
		 * ·���ֳַ����� 1. �������� �����̷��������ɵ��ļ�·�� 2. ���·�����ڵ�ǰ�ļ�Ŀ¼�µ�·��
		 */
		File file1 = new File("e:\\io\\hello.txt");
		File file2 = new File("hello2.txt");
		File file3 = new File("e:\\io\\io1");

		// File �ೣ�÷��� ��һ��

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

		// Ps! fil1.renanme( file2 ) ��Ҫ��֤ file1 һ������ file2 һ��Ҫ�����ڲ���

		// ���������·��ת����·�� file2 -->file Ҳ�����Ǿ���·��ת���·�� file -- > file2
		// ��һ��Ҫȷ�� �ļ� ��--�� �ļ� ������ �ļ�Ŀ¼��--���ļ�Ŀ¼
		boolean b = file1.renameTo(file3);
		System.out.println(b);

	}

}
