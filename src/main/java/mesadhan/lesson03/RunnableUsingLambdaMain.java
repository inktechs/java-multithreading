package mesadhan.lesson03;


public class RunnableUsingLambdaMain {

    public static void main(String[] args) {

        System.out.println("Thread Creating Using Lambda");

        final int size = 5;

        Runnable runnable1 = new Runnable() {
            public void run() {
                for (int i = 1; i < size; i++) {
                    System.out.println("Coming Person......" + i);

                    try { Thread.sleep(1000); } catch (Exception e) {}
                }
            }
        };

        // Replace using lambda expression
        Runnable runnable2 = () -> {

            for (int i = 1; i < size; i++) {
                System.out.println("Introduce Person......" + i);

                try { Thread.sleep(1000); } catch (Exception e) {}
            }
        };


        // synchronously execute your process
       /*
        runnable1.run();
        runnable2.run();
        */



        // Now, asynchronously execute your process
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();
    }

}
