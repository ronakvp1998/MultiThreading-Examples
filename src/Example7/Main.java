package Example7;

import Example6.SharedResource;

public class Main {
    public static void main(String[] args) {

        SharedResource sharedResource1 = new SharedResource();
        Thread th1 = new Thread(() -> {
            sharedResource1.produce();
        });

        SharedResource sharedResource2 = new SharedResource();
        Thread th2 = new Thread(() -> {
            sharedResource2.produce();
        });

        th1.start();
        th2.start();

    }
}
