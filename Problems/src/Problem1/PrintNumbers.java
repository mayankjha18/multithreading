package Problem1;

public class PrintNumbers implements Runnable {
    Object lock = null;
    int threadNo = 0;
    volatile static int count = 0;

    public PrintNumbers(Object lock, int threadNo)
    {
        this.lock = lock;
        this.threadNo = threadNo;
    }


    @Override
    public void run() {
        while(count <100)
        {
        synchronized (lock){

                if(threadNo == 1 && count % 3 ==0)
                {
                    print();
                }
                else if(threadNo == 2 && count % 3 ==1)
                {
                    print();
                }
                else if(threadNo == 3 && count % 3 ==2)
                {
                    print();
                }
                else
                {
                    lock.notifyAll();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
//        lock.notifyAll();
        System.out.println("Closing threadNo = " + threadNo);

    }

    private void print()
    {
        System.out.println("count = "+count +" & thread = "+threadNo);
        count++;
        lock.notifyAll();
        try {
            lock.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
