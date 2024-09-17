package Example5;

public class Main {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        System.out.println("Main Thread started");
        Thread th1 = new Thread(() -> {
            System.out.println("Thread 1 calling produce method");
            resource.produce();
        });
        th1.start();

        // main has to wait for thread 1 to finish
        try {
            th1.join();
        } catch (InterruptedException e) {

        }

        System.out.println("Main thread is finishing its work");
    }
}
