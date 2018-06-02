package Stream.ByteStream;

import sun.net.TelnetInputStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

//    由public abstract class InputStream提供的读取数据的基本方法，
//    TelnetOutputStream使用这些方法读取网络连接数据，FileOutputStream读取文件数据，
//    ByteArrayOutputStream读取可拓展的字节数组数据
//    public abstract int read() throws IOException
//    read方法从输入流的源中读取1个字节数据，作为一个0到255的int返回。流的结束
//    使用-1来表示。read()方法等待并阻塞其后任何代码的执行，直到有1字节的数据可供读取。
//    输入和输出可能很慢，所以如果程序在做其他重要的工作，要尽量将I/O放在单线程中
//    三个流的读取方法都是以-1表示流的结束
//    public int read(byte[] input) throws IOException
//    public int write(byte[] input,int offset,int length) throws IOException
//    public long skip(long n) throws IOException
//    public int available() throws IOException
//    public void close() throws IOException
public class LearnInputStream
{
    public void useStreamRead()
    {
        try(InputStream in=new FileInputStream("/tmp.txt"))
        {
            byte[] input=new byte[10];
            for(int i=0;i<input.length;i++)
            {
                int b=in.read();
                if(b==-1)
                    break;
                input[i]=(byte)b;
            }
        }
        catch (IOException ex)
        {
            System.err.println(ex.getMessage());
        }

    }
    //网络流中读取的方法
    public void useStreamReadInNetwork()
    {
        try(InputStream in=new FileInputStream("/Network"))//假设为网络流
        {
            int bytesRead=0;
            int bytesToRead=1024;
            byte[] input=new byte[bytesToRead];
            while (bytesRead<bytesToRead)
            {
                bytesRead+=in.read(input,bytesRead,bytesToRead-bytesRead);
                //存在BUG，即当流中的数据小于1024时会死循环
            }
            while (bytesRead<bytesToRead)
            {
                int result=in.read(input,bytesRead,bytesToRead-bytesRead);
                if(result==-1)
                    break;//流结束
                bytesRead+=result;
                //方法一
            }
            //方法二使用available()方法来确定不阻塞的情况下有多少字节可以读取
            int bytesAvailable=in.available();
            input=new byte[bytesAvailable];
            bytesRead=in.read(input,0,bytesAvailable);
            //在文件读取的时候因为文件是随机访问的可以使用skip()方法跳过数据
        }
//        允许程序备份和重新读取已经读取的数据
//        public void mark(int readAheadLimit)
//        public void reset() throw IOException
//        public boolean markSupported()
        catch (IOException ex)
        {
            System.err.println(ex.getMessage());
        }

    }
}
