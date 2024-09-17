package ThreadCreation;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Main method : " + Thread.currentThread().getName());
//        MultithreadingRunnable obj = new MultithreadingRunnable();
//        Thread thread = new Thread(obj);
//        thread.start();
//        System.out.println("finish main method : " + Thread.currentThread().getName());

        System.out.println("Main method : " + Thread.currentThread().getName());
        MultiThreadingExtends myThread = new MultiThreadingExtends();
        myThread.start();
        System.out.println("finish main method : " + Thread.currentThread().getName());

    }
}
