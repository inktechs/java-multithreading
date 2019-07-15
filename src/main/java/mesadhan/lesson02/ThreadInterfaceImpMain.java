package mesadhan.lesson02;

class Greeting implements Runnable {

    private int size;
    Greeting(int n) {
        size = n;
    }

    public void run() {
        for (int i = 1; i < size; i++) {
            System.out.println("Coming Person......" + i);

            try { Thread.sleep(1000); } catch (Exception e) {}
        }
    }
}

class Introduction implements Runnable {

    private int size;
    Introduction(int n) {
        size = n;
    }

    public void run() {
        for (int i = 1; i < size; i++) {
            System.out.println("Introduce Person......" + i);

            try { Thread.sleep(1000); } catch (Exception e) {}
        }
    }
}


public class ThreadInterfaceImpMain {

    public static void main(String[] args) {
        System.out.println("Thread Creating Using Interface");

        int people = 5;

        Runnable greeting = new Greeting(people);
        Runnable introduction = new Introduction(people);

        Thread thread1 = new Thread(greeting);
        Thread thread2 = new Thread(introduction);


        thread1.start();
        thread2.start();
    }

}
