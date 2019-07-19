package mesadhan.lesson06;

class Message {
    private int number;
    boolean isValueSet = false;


    public synchronized void setMessage(int number) {
        while (isValueSet){
            try { wait(); } catch (Exception e) { e.printStackTrace(); }
        }
        this.number = number;

        //System.out.println("Set: "+ number);
        isValueSet = true;
        notify();
    }

    public synchronized int getMessage() {
        while (!isValueSet){
            try { wait(); } catch (Exception e) { e.printStackTrace(); }
        }

        //System.out.println("Get: "+ number);
        isValueSet = false;
        notify();

        return number;
    }

}

class Producer implements Runnable {
    private Message message;

    public Producer(Message message) {
        this.message = message;
        Thread thread = new Thread(this, "Producer");       // this -> Runnable , ThreadName
        thread.start();
    }

    @Override
    public void run() {
        int number = 0;
        while (true) {
            message.setMessage(number++);
            try { Thread.sleep(1000); } catch (Exception e) { }
        }
    }
}

class Consumer implements Runnable {
    private Message message;

    public Consumer(Message message) {
        this.message = message;
        Thread thread = new Thread(this, "Consumer");       // this -> Runnable , ThreadName
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            int number = message.getMessage();
            System.out.println(number);
            try { Thread.sleep(2000); } catch (Exception e) { }
        }
    }
}


public class ThreadCommunication {

    public static void main(String[] args) {
        Message message = new Message();
        new Producer(message);
        new Consumer(message);
    }

}
