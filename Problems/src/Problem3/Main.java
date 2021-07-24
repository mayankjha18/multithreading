package Problem3;

/*
Create deadlock using threads
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1)
                {
                    System.out.println(" t1 acquired lock1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t1 waiting for lock2 ");
                    synchronized (lock2)
                    {
                        System.out.println(" t1 acquired lock2");
                    }
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2)
                {
                    System.out.println(" t2 acquired lock2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("t2 waiting for lock1 ");
                    synchronized (lock1)
                    {
                        System.out.println(" t2 acquired lock1");
                    }
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Main method is exiting..");
    }
}
