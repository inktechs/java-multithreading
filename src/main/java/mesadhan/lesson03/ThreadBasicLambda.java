package mesadhan.lesson03;

@SuppressWarnings("Duplicates")
public class ThreadBasicLambda {
    public static void main(String[] args) {
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
        thread2.start();

    }
}
