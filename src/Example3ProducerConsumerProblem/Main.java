package Example3ProducerConsumerProblem;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(3);
        // creating producer thread using lambda expression
        Thread producerThread = new Thread(() -> {
            try {
                for(int i=1;i<=6;i++){
                    sharedResource.produce(i);
                }
            }catch (Exception e){
                // handle exception here
            }
        });
        // creating consumer thread using lambda expression
        Thread consumerThread = new Thread(() -> {
            try{
                for(int i=1;i<=6;i++){
                    sharedResource.consume();
                }
            }catch (Exception e){
                // handle exception here
            }
        });
        producerThread.start();
        consumerThread.start();
    }
}
