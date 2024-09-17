package Example2;

public class Main {

    public static void main(String[] args) {

        System.out.println("Main method start ");
        // single object created for resource
        SharedResource sharedResource = new SharedResource();
        // Producer Thread
        Thread producerThread = new Thread(new ProduceTask(sharedResource));
        // consumer Thread
        Thread consumerThread = new Thread(new ConsumerTask(sharedResource));
        // Thread is in "Runnable state"
        producerThread.start();
        consumerThread.start();
        System.out.println("Main method end");
    }
}
