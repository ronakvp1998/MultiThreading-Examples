package Example2;

public class SharedResource {

    boolean itemAvailable = false;

    // synchronized put the monitor lock
    public synchronized void addItem(){
        itemAvailable = true;
        System.out.println("Item added by : "
                + Thread.currentThread().getName()
                +"and invoking all threads which are waiting");
        notifyAll();
    }

    public synchronized void consumeItem(){
        System.out.println("Consume Item method invoked by : "
                + Thread.currentThread().getName());

        // using while loop to avoid "supurious wake-up"
        // sometimes because of system noise

        while (!itemAvailable){
            try {
                System.out.println("Thread "
                + Thread.currentThread().getName()
                + " is waiting now");

                // It releases the monitor lock
                wait();
            }catch (Exception e){

            }
        }
    }
}
