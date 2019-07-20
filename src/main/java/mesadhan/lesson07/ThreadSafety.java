package mesadhan.lesson07;



class Counter extends Thread {

    private int counter;

    public synchronized void incrementCounter() {
        counter++;          //Not atomic operation. first fetch, adding value, then update value
    }

    public int getCounter() {
        return counter;
    }
}

public class ThreadSafety {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    counter.incrementCounter();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    counter.incrementCounter();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.format("Counter Value is:- %d", counter.getCounter());
        System.out.println("\nFinally Done Process");
    }

}



/*
//  Mutable [means change the variable value always]

// Immutable State
To avoid the problem where a sending thread changes the message when the message is read by another thread, messages should be immutable.
*/
