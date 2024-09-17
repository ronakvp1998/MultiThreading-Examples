package Example2.LambdaApproach;

public class Main {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();
        Thread producerThread = new Thread(()-> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
            sharedResource.addItem();
        });

        Thread consumeThread = new Thread(() -> {
            sharedResource.consumeItem();
        });

        producerThread.start();
        consumeThread.start();
    }
}
