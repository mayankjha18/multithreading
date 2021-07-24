package Problem2;

public class SimplePrinter implements Runnable {
    @Override
    public void run() {

        print();
    }


    private void print()
    {
        System.out.println("Inside run method of SimplePrinter class");
        throw new RuntimeException("Exception from " + Thread.currentThread().getName());
    }
}
