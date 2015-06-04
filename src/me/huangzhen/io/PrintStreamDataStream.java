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

// 打印流域数据流

public class PrintStreamDataStream
{
	
	
	//3. 数据流中的写入
	@Test
	public void test3() throws IOException  
	{
		DataInputStream dis = null;
		try
		{
			dis = new DataInputStream( new FileInputStream( new File(  "data.txt" ) ) );
			//这种方式不行，输出的还是乱码
			//对于数据流，写入的时候是什么格式，读出的时候也需要利用对应格式的方法
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
			//按照写入的顺序进行读出
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
	
	//2. 数据流 用来处理java中的基本数据类型以及String，char型数组 dataInputStream and dataOutputStream
	//数据流写入这里测试用 dataoutputstram 写入基本数据类型到一个文件中
	@Test
	public void test2()
	{
		DataOutputStream dos=null;
		try
		{
			FileOutputStream fos = new FileOutputStream( new File( "data.txt" ) );
			dos = new DataOutputStream(fos);
			
			dos.writeUTF("你是谁");
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

	//1. 关于打印流 PrintStream
	@Test
	public void test() throws FileNotFoundException
	{
		//1. 定义要作用的目标文件 
		File file = new File("test.txt");
		
		//2. 定义字节文件输出流
		FileOutputStream fos = new FileOutputStream(file);
		
		//3.定义打印流
		PrintStream ps = new PrintStream(fos);
		
		//4.重新设置打印流的位置，不是打印到控制台
		if ( ps != null )
		{
			System.setOut(ps);
		}
		
		//5.进行asc的打印
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
