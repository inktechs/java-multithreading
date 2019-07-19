package mesadhan.lesson05;

class Counter{
    private int count;
    public void increment(){
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class TreadSynchronized {
    public static void main(String[] args) throws Exception {
        Counter counter = new Counter();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <2000 ; i++) {
                    counter.increment();
                }
            }
        });

        thread1.start();
        //thread1.join();

        System.out.println("Count "+ counter.getCount());         // main thread executed
        Thread.sleep(100);                                  // make some delay,
        System.out.println("Count "+ counter.getCount());         // Now, Child Thread also Executed


        // Note: Here, We don't know when child thread basically completed so Tread Synchronization Use join() so that
        // Main thread and Child thread working sequentially.
    }
}
