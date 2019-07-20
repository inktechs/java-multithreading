package mesadhan.lesson06;

import java.util.Scanner;

class Counter implements Runnable {
    private int number = 0;
    private volatile boolean isStopThread = true;
    private volatile boolean processFlag = true;         // volatile ensure, In runtime Thread not use cache value.

    @Override
    public void run() {
        while (isStopThread) {

            while (processFlag){
                number++;
                System.out.println("Counter Number:- " + number);
                try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }

    public void isProcessClose() {
        processFlag = false;
    }

    public void isProcessStart() {
        processFlag = true;
    }

    public void threadStop() {
        isStopThread = false;
    }
    public void threadStart() {
        isStopThread = true;
    }

    public  boolean isStopThread() {
        return isStopThread;
    }
}

class InstructionMonitor implements Runnable {

    @Override
    public void run() {

        Counter counter = new Counter();
        Thread thread1 = new Thread(counter);
        thread1.start();

        while (true){
            //try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if(input.equalsIgnoreCase("c")){
                counter.isProcessClose();

                System.out.println("Thread Alive. Press S+Enter To Start Process");
                //System.out.print(thread1.isAlive());
            }
            if(input.equalsIgnoreCase("s")){
                counter.isProcessStart();

                System.out.println("Thread Alive.Press C+Enter To Close Process");
                //System.out.print(thread1.isAlive());
            }
        }

    }
}

public class ThreadVariableVolatile {

    public static void main(String[] args) {

        InstructionMonitor instructionMonitor = new InstructionMonitor();

        Thread thread2 = new Thread(instructionMonitor);
        thread2.start();


    }
}
