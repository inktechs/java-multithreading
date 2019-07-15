package mesadhan.lesson04;

@SuppressWarnings("Duplicates")
public class ThreadIdentification {

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



        // Set thread name so that identify
        thread1.setName("Thread: One");
        thread2.setName("Thread: Two");


        // get thread name so that identify
        System.out.println("Thread Name:"+  thread1.getName() );
        System.out.println("Thread Name:"+  thread2.getName() );

        thread1.start();
        thread2.start();

    }
}
