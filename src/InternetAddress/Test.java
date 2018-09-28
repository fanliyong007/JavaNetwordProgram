package InternetAddress;

import java.net.*;
import java.util.Scanner;

public class Test
{
    public static void main(String args[])
    {
        try
        {
            InetAddress ip=InetAddress.getLocalHost();
            String myip=ip.getHostName();
            System.out.print(myip);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
