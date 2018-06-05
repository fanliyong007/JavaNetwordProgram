package Thread;

public class TheWayToCreateThread
{

    public static void main(String args[])
    {
        System.out.println("begin");
        MyThread myThread=new MyThread();
        Thread thread=new Thread(myThread);
        thread.start();
        MyThread2 myThread2=new MyThread2();
        thread=new Thread(myThread2);
        thread.start();
        System.out.println("end");
    }

}
class MyThread extends Thread
{
    public void run()
    {
        System.out.println("通过继承实现");
    }
}
class MyThread2 implements Runnable
{
    public void run()
    {
        System.out.println("通过Runnable接口实现");
    }
}

