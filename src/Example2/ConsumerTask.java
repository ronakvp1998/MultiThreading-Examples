package Example2;

public class ConsumerTask implements Runnable {

    SharedResource sharedResource;

    ConsumerTask(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }


    @Override
    public void run() {
        System.out.println("Consume Thread : "
        + Thread.currentThread().getName());

        sharedResource.consumeItem();
    }
}