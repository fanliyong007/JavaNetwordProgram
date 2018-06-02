package Stream.ByteStream;

import java.io.*;

public class LearnBufferedStream
{
    public void test() throws FileNotFoundException {
        FileInputStream fin=new FileInputStream("data.txt");
        BufferedInputStream bin=new BufferedInputStream(fin);
        //将过滤器串链在一起

    }
//    public BufferedInputStream(InputStream in)
//    public BufferedInputStream(InputStream in,int bufferSize)
//    public BufferedOutputStream(OutputStream out)
//    public BufferedOutputStream(OutputStream out,int bufferSize)
//    默认输入流的缓冲区大小设置为2048字节，输出流的缓冲区大小设置为512字节

}
