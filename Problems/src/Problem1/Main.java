package Problem1;

/*
Print numbers from 1 to 100 using three threads
 */

public class Main {
    public static void main(String[] args)
    {
        Object lock = new Object();
        Thread t1 = new Thread(new PrintNumbers(lock, 1));
        Thread t2 = new Thread(new PrintNumbers(lock, 2));
        Thread t3 = new Thread(new PrintNumbers(lock, 3));
        t1.start();
        t2.start();
        t3.start();
    }
}
