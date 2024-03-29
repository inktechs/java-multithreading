package mesadhan.lesson04;

@SuppressWarnings("Duplicates")
public class ThreadJoinLambda {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Thread Basic Using Lambda");

        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("Process........1");
                try { Thread.sleep(1000); } catch (Exception e) {}
            }
        });

        Thread thread2 = new Thread(()-> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Process........2");
                try { Thread.sleep(1000); } catch (Exception e) {}
            }
        });



        thread1.start();
        try { Thread.sleep(1000); } catch (Exception e) {}
        thread2.start();


        // join method calling so that unit thread align with main thread
        thread1.join();
        thread2.join();


        System.out.println("Hello, How is going on");

    }
}
