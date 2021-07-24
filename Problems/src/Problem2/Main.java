package Problem2;

/*
How to catch exception thrown by child thread
 */

import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main (String[] args) throws InterruptedException {

        //Thread 1 - It throws the exception and there is no way to catch from main
        Thread t1 =  new Thread(new SimplePrinter());
        t1.setName("1st thread");
        try
        {
            t1.start();
        }
        catch (Exception e)
        {
            //this catch is not capable of catching thread thrown by  child thread
            System.out.println("THIS IS NOT EXECUTED");
        }
        t1.join();
        System.out.println("After starting thread");

        // Thread 2 - It throws the exception which is wrapped in reference and we are able to check it in main
        AtomicReference<Exception> ex = new AtomicReference<>();
        Thread t2 = new Thread(new AdvancePrinter(ex));
        t2.setName("2nd thread");
        t2.start();
        t2.join();
        if(ex.get() != null)
        {
           System.out.println(ex.get().getMessage());
        }

        //Thread 3 - Using UncaughtExceptionHandler - a better way to set exception while catching from Thread.UncaughtExceptionHandler
        Thread t3 = new Thread(new Downloader());
        Thread.UncaughtExceptionHandler exceptionHandler = new DatalinkUncaughtExceptionHandler();
        t3.setUncaughtExceptionHandler(exceptionHandler);
        t3.start();
        t3.join();
        Throwable th = ((DatalinkUncaughtExceptionHandler) exceptionHandler).getThrown();
        if(th!=null)
        {
            System.out.println("Some exception during download execution");
        }

    }
}
