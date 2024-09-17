package Example16;

public class SharedResource {
    int counter;

    public void increment(){
        System.out.println(Thread.currentThread().getName());
        counter++;
    }

    public int get(){
        return counter;
    }
}
