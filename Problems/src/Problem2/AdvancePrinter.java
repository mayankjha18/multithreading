package Problem2;

import java.util.concurrent.atomic.AtomicReference;

public class AdvancePrinter implements Runnable {
    public volatile AtomicReference<Exception> ex;
    public AdvancePrinter(AtomicReference<Exception> ex)
    {
        this.ex = ex;
    }
    @Override
    public void run() {
        try
        {
         print();
        }
        catch (Exception e)
        {
         ex.set(e);
        }
    }


    private void print()
    {
        System.out.println("Inside run method of AdvancePrinter  class");
        throw new RuntimeException("Exception from " + Thread.currentThread().getName());
    }
}
