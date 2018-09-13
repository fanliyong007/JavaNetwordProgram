package InternetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ShowIP
{
    private String name;
    ShowIP(String name)
    {
        this.name=name;
    }
    public void printIP()
    {
        try
        {
            InetAddress address=InetAddress.getByName(name);
            System.out.println(address.toString().split("/")[1]);
        }
        catch (UnknownHostException ex)
        {
            System.out.println("Could not find "+name);
        }
    }
    public void printDomain()
    {
        try
        {
            InetAddress address=InetAddress.getByName(name);
            System.out.println(address.getHostName());
        }
        catch (UnknownHostException ex)
        {
            System.out.println("Could not find "+name);
        }
    }
}
