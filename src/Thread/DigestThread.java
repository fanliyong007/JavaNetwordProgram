package Thread;

import javax.xml.bind.DatatypeConverter;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

public class DigestThread extends Thread
{
    private String filename;
    public DigestThread(String filename)
    {
        this.filename=filename;
    }
    public void run()
    {
        try
        {
            FileInputStream in=new FileInputStream(filename);
            MessageDigest sha=MessageDigest.getInstance("SHA-256");
            DigestInputStream din=new DigestInputStream(in,sha);
            while(din.read()!=-1);
            din.close();
            byte[] digest=sha.digest();
            StringBuilder result=new StringBuilder(filename);
            result.append(":");
            result.append(DatatypeConverter.printHexBinary(digest));
            System.out.println(result);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    public static void main(String args[])
    {
        for(String filename:args)
        {
            Thread thread=new DigestThread(filename);
            thread.start();
        }
    }
}
