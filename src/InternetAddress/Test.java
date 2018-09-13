package InternetAddress;

import java.util.Scanner;

public class Test
{
    public static void main(String args[])
    {
        Scanner read=new Scanner(System.in);
        String name=read.nextLine();
        ShowIP showIP=new ShowIP(name);
        showIP.printIP();
        showIP.printDomain();
    }
}
