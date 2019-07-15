package mesadhan.lesson01;


class Greeting extends Thread {

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

class Introduction extends Thread {

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


public class ThreadBasicMain {

    public static void main(String[] args) {

        System.out.println("Thread Basic Implementation");

        int people = 5;
        Greeting greeting = new Greeting(people);
        Introduction introduction = new Introduction(people);


        greeting.start();
        introduction.start();
    }

}
