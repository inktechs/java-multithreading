package mesadhan;

class Greeting {
    private int size;
    Greeting(int n) {
        size = n;
    }

    public void action() {
        for (int i = 1; i < size; i++) {
            System.out.println("Coming Person......" + i);

            try { Thread.sleep(1000); } catch (Exception e) {}
        }
    }
}

class Introduction {
    private int size;
    Introduction(int n) {
        size = n;
    }

    public void action() {
        for (int i = 1; i < size; i++) {
            System.out.println("Introduce Person......" + i);

            try { Thread.sleep(1000); } catch (Exception e) {}
        }
    }
}


public class SingleThread {

    // Single Thread
    public static void main(String[] args) {

        int people = 5;

        Greeting greeting = new Greeting(people);
        Introduction introduction = new Introduction(people);


        greeting.action();
        introduction.action();
    }
}

/*

Note: Here using single thread so synchronously done one by one. after execute greeting.action()
then start introduction.action(). Both happen in single thread so parallelism not possible.
That why we can use multiple thread, So that unit of process run behind main process.

*/