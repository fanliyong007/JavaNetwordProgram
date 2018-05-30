package Stream;

import sun.net.TelnetOutputStream;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//    由public abstract class OutputStream提供的写入数据的基本方法，
//    TelnetOutputStream使用这些方法将数据写入网络连接，FileOutputStream将数据写入文件，
//    ByteArrayOutputStream将数据写入可拓展的字节数组
//    public abstract void write(int b) throws IOException这个方法只能接受0~255之间的整数，
//    用于写入输出流中，当其写入一个网络连接但是超过255的时候只会写如这个数字的最低字节
//    public void write(byte[] data) throws IOException
//    public void write(byte[] data,int offset,int length) throws IOException
//    public void flush() throws IOException
//    public void close() throws IOException
public class LearnOutputStream
{
    public static void main(String args[])
    {
        System.out.print("yo");
    }
    public static void generateCharacters(OutputStream out)
        throws IOException
    {
        int firstPrintableCharacter=33;
        int numberOfPrintableCharacters=94;
        int numberOifCharactersPerLine=72;
        int start=firstPrintableCharacter;

        while(true)
        {
            for(int i=start;i<start+numberOifCharactersPerLine;i++)
            {
                out.write((
                        (i-firstPrintableCharacter)%numberOfPrintableCharacters)
                        +firstPrintableCharacter);
            }
            out.write('\r');//enter
            out.write('\n');//Line wrap
            start=((start+1)-firstPrintableCharacter)%numberOfPrintableCharacters+firstPrintableCharacter;
        }

    }

    public void hyperGenerateCharacters(OutputStream out)
            throws IOException
    {
        //在网络流中一次写入一个字节通常效率不高，因为每个TCP分片包含至少40字节的开销用于路由和纠错。如果
        //每个字节都单独发送数据可能会高出41倍以上。使用write(byte[] data)
        // 或write(byte[] dara,int offset,int length)通常比一次写入data数组中的1字节快的多。

        int firstPrintableCharacter = 33;
        int numberOfPrintableCharacters = 94;
        int numberOifCharactersPerLine = 72;
        int start = firstPrintableCharacter;
        byte[] line=new byte[numberOifCharactersPerLine+2];//2个字节用于回车和换行
        while (true)
        {
            for (int i = start; i < start + numberOifCharactersPerLine; i++)
            {
               line[i-start]=(byte)((i-firstPrintableCharacter)%numberOifCharactersPerLine+firstPrintableCharacter);
            }
            line[72]=(byte)'\r';//enter
            line[73]=(byte)'\n';//Line wrap
            out.write(line);
            start = ((start + 1) - firstPrintableCharacter) % numberOfPrintableCharacters + firstPrintableCharacter;
            //记得使用flush()刷新流否则会一直在缓冲区导致丢失
        }
    }

    public void aboutCloseStream()
    {
        //Java6以及老版本的释放模式(dispose parrern)
        OutputStream out=null;
        try
        {
            out=new FileOutputStream("/tmp.txt");
            //处理输出流
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
        finally
        {
         if(out!=null)
         {
             try
             {
                 out.close();
                 //在finally当中关闭流是较安全的，但是关闭之前注意一定要检查流对象是否是null,以免
                 //NullPointerException异常
             }
             catch (IOException e)
             {
                 e.printStackTrace();
             }
         }
        }
        //Java7 “带资源的try”构造
        try(OutputStream outputStream=new FileOutputStream("/tmp.txt"))
        {
            //处理输出流代码
        }
        catch (IOException ex)
        {
            System.err.println(ex.getMessage());
        }
//        只要对象实现了Closeable接口，都可以使用这种方式，这包括几乎所有需要释放的对象。
//        到目前为止作者只见过JavaMail Transport对象是还需要显示的释放
    }

}
