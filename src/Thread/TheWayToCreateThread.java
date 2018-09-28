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
        thread.setPriority(8);//设置线程优先级
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
        Thread.yield();//线程放弃现有资源但是不会放弃他的锁
        try
        {
            Thread.sleep(10000);//线程休眠
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

