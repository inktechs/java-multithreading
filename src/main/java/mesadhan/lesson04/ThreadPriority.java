package mesadhan.lesson04;

@SuppressWarnings("Duplicates")
public class ThreadPriority {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Thread Basic Using Lambda");

        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("Process........One");
                try { Thread.sleep(1000); } catch (Exception e) {}
            }
        });

        Thread thread2 = new Thread(()-> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Process........2");
                try { Thread.sleep(1000); } catch (Exception e) {}
            }
        });


        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();

    }
}
