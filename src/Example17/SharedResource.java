package Example17;

public class SharedResource {
    int counter;

    public synchronized void increment(){
        System.out.println(Thread.currentThread().getName());
        counter++;
    }

    public int get(){
        return counter;
    }
}
