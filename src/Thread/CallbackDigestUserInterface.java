package Thread;

import javax.xml.bind.DatatypeConverter;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

/**
 * 线程通过调用主方法所在类中的一个方法来得到线程结束的通知
 */
class CallbackDigest implements Runnable
{
    private String filename;
    public CallbackDigest(String filename)
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
            while (din.read()!=-1);
            din.close();
            byte[] digest=sha.digest();
            CallbackDigestUserInterface.receiveDigest(digest,filename);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }
}
public class CallbackDigestUserInterface
{
    public static void receiveDigest(byte[] digest,String name)
    {
        StringBuilder result=new StringBuilder(name);
        result.append(": ");
        result.append(DatatypeConverter.printHexBinary(digest));
        System.out.println(result);
    }
    public static void main(String[] args)
    {
        for(String filename : args)
        {
            CallbackDigest cb=new CallbackDigest(filename);
            Thread t=new Thread(cb);
            t.start();
        }
    }
}
