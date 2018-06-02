package Stream.CharacterStream;

import java.io.*;

//BufferedReader, CharArrayReader, FilterReader, InputStreamReader, PipedReader, StringReader
//protected	Reader()
//    Creates a new character-stream reader whose critical sections will synchronize on the reader itself.
//protected	Reader(Object lock)
//        Creates a new character-stream reader whose critical sections will synchronize on the given object.
//    abstract void	close()
//    Closes the stream and releases any system resources associated with it.
//    void	mark(int readAheadLimit)
//    Marks the present position in the stream.
//    boolean	markSupported()
//    Tells whether this stream supports the mark() operation.
//    int	read()
//    Reads a single character.
//    int	read(char[] cbuf)
//    Reads characters into an array.
//    abstract int	read(char[] cbuf, int off, int len)
//    Reads characters into a portion of an array.
//    int	read(CharBuffer target)
//    Attempts to read characters into the specified character buffer.
//    boolean	ready()
//    Tells whether this stream is ready to be read.
//    void	reset()
//    Resets the stream.
//    long	skip(long n)
//    Skips characters.
public class LearnReader
{
    public static String getMacCyrillicString(InputStream in)
        throws IOException
    {
        Reader r=new InputStreamReader(in,"MacCyrillic");
        r=new BufferedReader(r,1024);
        StringBuilder sb=new StringBuilder();
        int c;
        while((c=r.read())!=-1)
            sb.append((char)c);
        return sb.toString();
    }
}


