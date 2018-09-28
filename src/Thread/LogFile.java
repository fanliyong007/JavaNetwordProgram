package Thread;

import java.io.*;
import java.util.Date;

public class LogFile
{
    private Writer out;

    public LogFile(File f) throws IOException
    {
        FileWriter fw = new FileWriter(f);
        this.out = new BufferedWriter(fw);
    }

    //第一种对Writer对象out同步
    public void writeEntry1(String message) throws IOException
    {
        synchronized (out)
        {
            Date d = new Date();
            out.write(d.toString());
            out.write('\t');
            out.write(message);
            out.write("\r\n");
        }
    }

    //第二种对LogFile对象本身同步
    public void writeEntry2(String message) throws IOException
    {
        synchronized (this)
        {
            Date d = new Date();
            out.write(d.toString());
            out.write('\t');
            out.write(message);
            out.write("\r\n");
        }
    }
    //第二种的另一个方式
    public synchronized void writeEntry3(String message) throws IOException
    {
            Date d = new Date();
            out.write(d.toString());
            out.write('\t');
            out.write(message);
            out.write("\r\n");
    }
    public void close() throws IOException
    {
        out.flush();
        out.close();
    }
}
