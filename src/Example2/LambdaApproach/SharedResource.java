package Example2.LambdaApproach;

public class SharedResource {

    boolean isItemPresent = false;

    public synchronized void addItem(){
        System.out.println("Producer Thread calling notify all method");
        isItemPresent = true;
        notifyAll();
    }

    public synchronized void consumeItem(){
        System.out.println("Consumer Thread inside consume item method");
        while (!isItemPresent){
            try{
                System.out.println("Consumer thread is waiting");
                wait();
            }catch (Exception e){

            }
        }
        System.out.println("Consumer Thread consumed item");
        isItemPresent = false;
    }
}
